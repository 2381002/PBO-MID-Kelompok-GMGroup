package rumahTangga.services;

import org.springframework.stereotype.Component;
import rumahTangga.entities.RumahTangga;
import rumahTangga.repositories.RumahTanggaRepository;

@Component
public class RumahTanggaServiceImpl implements RumahTanggaService {
    private final RumahTanggaRepository rumahTanggaRepository;

    public RumahTanggaServiceImpl(RumahTanggaRepository rumahTanggaRepository) {
        this.rumahTanggaRepository = rumahTanggaRepository;
    }

    @Override
    public RumahTangga[] getRumahTanggaList() {
        return rumahTanggaRepository.getAll();
    }

    @Override
    public void addRumahTangga(final String todo) {
        if (todo.isBlank() || todo.isEmpty()) {
            System.out.println("Masukkan todo dengan benar");
            return;
        }
        RumahTangga rumahTangga = new RumahTangga();
        rumahTangga.setTodo(todo);
        rumahTanggaRepository.add(rumahTangga);
    }

    @Override
    public Boolean removeRumahTangga(final Integer number) {
        return rumahTanggaRepository.remove(number);
    }

    @Override
    public Boolean editRumahTangga(final Integer number, String todo) {
        RumahTangga rumahTangga = new RumahTangga();
        rumahTangga.setTodo(todo);
        rumahTangga.setId(number);
        return rumahTanggaRepository.edit(rumahTangga);
    }
}