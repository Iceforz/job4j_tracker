package ru.job4j.streamapi;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
   public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).
                sorted(new AddressCompare()).distinct().collect(Collectors.toList());
    }
}

