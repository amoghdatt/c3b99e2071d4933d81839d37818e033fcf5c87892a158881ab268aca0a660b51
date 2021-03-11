package family.service.relationship;

import java.util.ArrayList;

import family.FamilyMember;

public class Siblings extends Relationship {

    @Override
    public ArrayList<String> getPeople(FamilyMember member) {
        ArrayList<FamilyMember> siblings = member.getSiblings();
        return getAllMembersFromArrayExceptOne(siblings, member.getName());

    }
    
}
