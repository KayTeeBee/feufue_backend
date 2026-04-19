package de.feufue.util;

import de.feufue.model.objects.BOSNumber;
import de.feufue.model.objects.FireDepartment;
import de.feufue.model.objects.Group;
import de.feufue.model.objects.MapLocation;

public class GroupUtils {
    
    public static MapLocation getCurrentPosition(Group group) {
        if (group.getCurrentStation() != null) {
            return group.getCurrentStation().getLocation();
        }
        BOSNumber bosNumber = group.getBosNumber();
        FireDepartment fireDepartment = BOSNumberUtils.getFireDepartment(bosNumber);
        return (fireDepartment != null) ? fireDepartment.getLocation() : null;
    }

}
