package family.service.relationship;

import java.util.ArrayList;

import family.FamilyMember;

public class Daughter extends Relationship {

    @Override
    public ArrayList<String> getPeople(FamilyMember member) {
        ArrayList<FamilyMember> children = member.getChildren();
        if(children != null)
            return getAllMembersFromArrayBasedOnGender(children, "Female");
        else return null;
    }
    
}
