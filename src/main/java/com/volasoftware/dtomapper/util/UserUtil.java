package com.volasoftware.dtomapper.util;

import com.volasoftware.dtomapper.enums.Country;
import com.volasoftware.dtomapper.model.Location;
import com.volasoftware.dtomapper.model.User;

import java.util.List;
import java.util.Set;

public class UserUtil {

    public static List<User> getInitialUsers() {
        User user1 = new User("John", "Doe", "john.doe@gmail.com", "password",
                new Location(Country.USA, "NY", "Somewhere")
        );
        User user2 = new User("John", "Snow", "john.snow@gmail.com", "password",
                new Location(Country.THE_NORTH, "Winterfell", "Main street")
        );
        User user3 = new User("John", "Gol", "john.gol@gmail.com", "password",
                new Location(Country.BULGARIA, "Vratsa", "ul. Probiva 1a")
        );

        user1.setFollowers(Set.of(user2));
        user2.setFollowers(Set.of(user3));
//        user3.setFollowers(Set.of(user1));

        return List.of(user1, user2, user3);
    }
}
