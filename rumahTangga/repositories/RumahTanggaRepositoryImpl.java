package rumahTangga.repositories;

import rumahTangga.entities.RumahTangga;

public class RumahTanggaRepositoryImpl implements RumahTanggaRepository {
    public static RumahTangga[] rumahTanggas = new RumahTangga[2];

    @Override
    public RumahTangga[] getAll() {
        return rumahTanggas;
    }

    @Override
    public void add(final RumahTangga rumahTangga) {
        resizeArrayIfFull();

        // add rumahTangga to array that has null element
        for (int i = 0; i < rumahTanggas.length; i++) {
            if (rumahTanggas[i] == null) {
                rumahTanggas[i] = rumahTangga;
                break;
            }
        }
    }

    private void resizeArrayIfFull() {
        // check whether rumahTanggas is full
        Boolean isFull = true;
        isFull = isArrayFull(isFull);

        // if full, resize current array two times bigger
        if (isFull) {
            resizeArrayToTwoTimesBigger();
        }
    }

    private void resizeArrayToTwoTimesBigger() {
        RumahTangga[] temp = rumahTanggas;
        rumahTanggas = new RumahTangga[rumahTanggas.length * 2];
        for (int i = 0; i < temp.length; i++) {
            rumahTanggas[i] = temp[i];
        }
    }

    private Boolean isArrayFull(Boolean isFull) {
        for (int i = 0; i < rumahTanggas.length; i++) {
            if (rumahTanggas[i] == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    @Override
    public Boolean remove(final Integer number) {
        if (isSelectedRumahTanggaNotValid(number)) {
            return false;
        }

        for (int i = number - 1; i < rumahTanggas.length; i++) {
            // if rumahTangga is the last element
            if (i == (rumahTanggas.length - 1)) {
                rumahTanggas[i] = null;
            } else {
                // replace with the element on the right
                rumahTanggas[i] = rumahTanggas[i + 1];
            }
        }
        return true;
    }

    private static boolean isSelected RumahTanggaNotValid(final Integer number) {
        // check if the number is zero or less than zero
        if (number <= 0) {
            return true;
        }

        // check if the number is greater than the rumahTanggas size/length
        if (number - 1 > rumahTanggas.length - 1) {
            return true;
        }

        // check whether the element is already null
        if (rumahTanggas[number - 1] == null) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean edit(final RumahTangga rumahTangga) {
        if (isSelectedRumahTanggaNotValid(rumahTangga.getId())) {
            return false;
        }
        rumahTanggas[rumahTangga.getId() - 1] = rumahTangga;
        return true;
    }
}