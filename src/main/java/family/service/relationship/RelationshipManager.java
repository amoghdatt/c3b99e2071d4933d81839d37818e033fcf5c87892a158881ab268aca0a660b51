package family.service.relationship;

import java.util.ArrayList;
import java.util.HashMap;
import family.Family;
import family.FamilyMember;
import family.exceptions.MemberNotFoundException;

import family.service.Service;

/**
 * The Relationship manager class is one stop location for all relationship related tasks of a family.
 * In This class we can find methods that handles and governs fetching and finding of relationship between family members of a given family
 * The class extends a Service class
 */
public class RelationshipManager extends Service {

    static HashMap<String, Relationship> relationshipMapper = new HashMap<>();

    static{
        relationshipMapper.put("Brother-In-Law", new BrotherInLaw());
        relationshipMapper.put("Sister-In-Law", new SisterInLaw());
        relationshipMapper.put("Maternal-Aunt", new MaternalAunt());
        relationshipMapper.put("Maternal-Uncle", new MaternalUncle());
        relationshipMapper.put("Paternal-Aunt", new PaternalAunt());
        relationshipMapper.put("Paternal-Uncle", new PaternalUncle());
        relationshipMapper.put("Siblings", new Siblings());
        relationshipMapper.put("Son", new Son());
        relationshipMapper.put("Daughter", new Daughter());
    }

    public RelationshipManager(Family family) {
        super(family);
    }

    /**
    * This method prints all members
    * @param members List of releveant family member names
    * @return Nothing
    */
    private void printMembers(ArrayList<String> members){
        if(members == null || members.size() == 0 ) {
            System.out.println("NONE");
            return;
        }

        for(String member : members){
            System.out.print(member+" ");
        }
        System.out.print("\n");
    }

    /**
    * This is a manager method that co-ordinates all tasks related to handling of relationship between family members
    * @param name This is the name of the family member whose relatives has to be determined
    * @param relationship  This mentions the relationship that determines the relatived that need to be fetched 
    * @return Nothing 
    */
    public void handleRelationship(String name, String relationship) {

        try {
            family.validateMembership(name);
        } catch (MemberNotFoundException e) {
            System.out.println("PERSON_NOT_FOUND");
            return;
        }

        FamilyMember member = familyMembers.get(name);
        ArrayList<String> members = relationshipMapper.get(relationship).getPeople(member);
        printMembers(members);
    }
}
