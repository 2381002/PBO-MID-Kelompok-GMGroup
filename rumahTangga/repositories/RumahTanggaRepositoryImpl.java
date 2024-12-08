package rumahTangga.repositories;

import rumahTangga.entities.RumahTangga;

import java.util.ArrayList;
import java.util.List;

public class RumahTanggaRepositoryImpl implements RumahTanggaRepository {
    private static List<RumahTangga> rumahTanggas = new ArrayList<>();

    @Override
    public RumahTangga[] getAll() {
        return rumahTanggas.toArray(new RumahTangga[0]);
    }

    @Override
    public void add(final RumahTangga rumahTangga) {
        if (rumahTangga == null) {
            throw new IllegalArgumentException("RumahTangga cannot be null");
        }
        rumahTanggas.add(rumahTangga);
    }

    @Override
    public Boolean remove(final Integer number) {
        if (isSelectedRumahTanggaNotValid(number)) {
            return false;
        }
        rumahTanggas.remove((int) (number - 1));
        return true;
    }

    private static boolean isSelectedRumahTanggaNotValid(final Integer number) {
        if (number == null || number <= 0 || number > rumahTanggas.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean edit(final RumahTangga rumahTangga) {
        if (rumahTangga == null || isSelectedRumahTanggaNotValid(rumahTangga.getId())) {
            return false;
        }
        rumahTanggas.set(rumahTangga.getId() - 1, rumahTangga);
        return true;
    }
}