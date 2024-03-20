package softuni.exam.service.impl;

import softuni.exam.service.ConstellationService;

import java.io.IOException;

public class ConstellationServiceImpl implements ConstellationService {

    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return null;
    }

    @Override
    public String importConstellations() throws IOException {
        return null;
    }
}
