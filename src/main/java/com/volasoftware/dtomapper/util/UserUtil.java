package com.volasoftware.dtomapper.util;

import com.volasoftware.dtomapper.enums.Country;
import com.volasoftware.dtomapper.model.Location;
import com.volasoftware.dtomapper.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class UserUtil {

    public static List<User> getInitialUsers() {
        User user1 = new User(
                "John",
                "Doe",
                LocalDate.of(2001, 1, 1),
                LocalDateTime.now().minusHours(5),
                "john.doe@gmail.com",
                "password",
                new Location(Country.USA, "NY", "Somewhere")
        );
        User user2 = new User(
                "John",
                "Snow",
                LocalDate.of(1990, 3, 3),
                LocalDateTime.now().minusDays(5),
                "john.snow@gmail.com",
                "password",
                new Location(Country.THE_NORTH, "Winterfell", "Main street")
        );
        User user3 = new User("John",
                "Gol",
                LocalDate.of(2000, 12, 12),
                LocalDateTime.now(),
                "john.gol@gmail.com",
                "password",
                new Location(Country.BULGARIA, "Vratsa", "ul. Probiva 1a")
        );

        user1.setFollowers(Set.of(user2));
        user2.setFollowers(Set.of(user3));
        user3.setFollowers(Set.of(user1));

        return List.of(user1, user2, user3);
    }
}
