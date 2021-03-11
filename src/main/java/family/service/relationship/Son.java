package family.service.relationship;

import java.util.ArrayList;

import family.FamilyMember;

public class Son extends Relationship {
    
    @Override
    public ArrayList<String> getPeople(FamilyMember member) {
        ArrayList<FamilyMember> children = member.getChildren();
        if (children != null)
            return getAllMembersFromArrayBasedOnGender(children, "Male");
        else
            return null;
    }
}
