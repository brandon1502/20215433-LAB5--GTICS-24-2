package com.example.demo.controller;


import com.example.demo.entity.Mascota;
import com.example.demo.entity.Viaje;
import com.example.demo.repository.LugarRepository;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.repository.ViajeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private final LugarRepository lugarRepository;
    private final MascotaRepository mascotaRepository;
    private final PersonaRepository personaRepository;

    private final ViajeRepository viajeRepository;


    public HomeController(LugarRepository lugarRepository,
                          MascotaRepository mascotaRepository,
                          PersonaRepository personaRepository,
                          ViajeRepository viajeRepository) {
        this.lugarRepository = lugarRepository;
        this.mascotaRepository = mascotaRepository;
        this.personaRepository = personaRepository;
        this.viajeRepository = viajeRepository;
    }
    @GetMapping("gestion/pagPrincipal")
    public String paginaPrincipal(Model model ){



        return "vistas/pagPrincipal";
    }

    @GetMapping("gestion/viajes")
    public String listaViajes(Model model ){

        List<Viaje> listaViajes = viajeRepository.findAll();
        model.addAttribute("listaViajes", listaViajes);


        return "vistas/viajes";
    }


    @GetMapping("/gestion/nuevoViaje")
    public String nuevoEmployeeFrm(Model model) {

        model.addAttribute("listaPersonas",personaRepository.findAll());
        model.addAttribute("listaLugares",lugarRepository.findAll());

        return "vistas/nuevoViaje";
    }

    @PostMapping("/gestion/save")
    public String guardarEmployee(Viaje viaje, RedirectAttributes attr) {

        if (viaje.getId() == 0) {
            attr.addFlashAttribute("msg", "Viaje creado exitosamente");
        } else {
            attr.addFlashAttribute("msg", "Viaje actualizado exitosamente");
        }

        viajeRepository.save(viaje);

        return "redirect:/gestion/viajes";
    }



    @GetMapping("gestion/verDetalles")
    public String verDetalles(Model model,
                              @RequestParam("id") int id) {

        Optional<Viaje> optViaje = viajeRepository.findById(id);

        if (optViaje.isPresent()) {
            Viaje viaje = optViaje.get();
            model.addAttribute("viaje", viaje);
            return "vistas/verDetalles";
        } else {
            return "redirect:/vistas/viajes";
        }
    }

    @GetMapping("gestion/edit")
    public String editarViaje(Model model,
                              @RequestParam("id") int id) {

        Optional<Viaje> optViaje = viajeRepository.findById(id);

        if (optViaje.isPresent()) {
            Viaje viaje = optViaje.get();
            model.addAttribute("viaje", viaje);
            model.addAttribute("listaPersonas",personaRepository.findAll());
            model.addAttribute("listaLugares",lugarRepository.findAll());
            return "vistas/editarViaje";
        } else {
            return "redirect:/vistas/viajes";
        }
    }


    @GetMapping("gestion/mascotas")
    public String listaMascotas(Model model ){

        List<Mascota> listMascotas = mascotaRepository.findAll();
        model.addAttribute("listMascotas", listMascotas);


        return "vistas/mascotas";
    }

    @GetMapping("/mascota/nuevaMascota")
    public String nuevaMascota(Model model) {

        model.addAttribute("listaPersonas",personaRepository.findAll());

        return "vistas/nuevaMascota";
    }

    @PostMapping("/mascota/save")
    public String guardarMascota(Mascota mascota, RedirectAttributes attr) {

        if (mascota.getId() == 0) {
            attr.addFlashAttribute("msg", "Viaje creado exitosamente");
        } else {
            attr.addFlashAttribute("msg", "Viaje actualizado exitosamente");
        }

        mascotaRepository.save(mascota);

        return "redirect:/gestion/mascotas";
    }

    @GetMapping("mascota/verDetalles")
    public String verDetallesMascota(Model model,
                              @RequestParam("id") int id) {

        Optional<Mascota> optViaje = mascotaRepository.findById(id);

        if (optViaje.isPresent()) {
            Mascota mascota = optViaje.get();
            model.addAttribute("mascota", mascota);
            return "vistas/verDetallesMascota";
        } else {
            return "redirect:/vistas/mascotas";
        }
    }

}
