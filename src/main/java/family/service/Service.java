package family.service;

import java.util.HashMap;

import family.Family;
import family.FamilyMember;

/**
 * The base class from which we can extend and generate new classes to provide any type service to family.
 * 
 */
public class Service {

    protected Family family = null;  
    protected HashMap<String, FamilyMember> familyMembers;

    public Service(Family family ){
        this.family = family;
        this.familyMembers = family.getFamilyMembers();
    }


}
