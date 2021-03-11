package family;
import java.util.*;

import family.exceptions.IllegalParentException;
import family.exceptions.InvalidGenderException;
import family.exceptions.MemberNotFoundException;
import family.exceptions.SiblingsNotFoundException;

/**
 * The family member class that forms the most basic unit of a family.
 * 
 */
public class FamilyMember extends Person{

    private Family familyPartOf;
    private FamilyMember spouse = null;
    private FamilyMember father = null;
    private FamilyMember mother = null;
    private ArrayList<FamilyMember> children = null;
        
        public FamilyMember(String name, String gender, FamilyMember father, FamilyMember mother, Family familyPartOf){
            super(name, gender);
            this.father = father;
            this.mother = mother;
            this.familyPartOf = familyPartOf;
        }


        
        /**
        * This method is used to validate whether person is married.
        * @exception IllegalParentException Thrown when member is not married
        * @return Nothing
        */
        public void validateMarriage() throws IllegalParentException {
            if(!this.isMarried())
                throw new IllegalParentException("Member not married");
        }

       
        public boolean isMarried(){
            return spouse != null;
        }
     
        public void setSpouse(FamilyMember spouse) {
            this.spouse = spouse;
        }

        public FamilyMember getSpouse() {
            return spouse;
        }

        public FamilyMember getFather() {
            return father;
        }

        public FamilyMember getMother() {
            return mother;
        }
        
        public void setChildren(ArrayList<FamilyMember> children) {
            this.children = children;
        }

        public ArrayList<FamilyMember> getChildren() {
            return children;
        }

        public void addChild(FamilyMember child){
            this.children.add(child);
        }

        // public void validateSiblings() throws SiblingsNotFoundException {
        //     if(getSiblings().size() == 1){
        //         throw new SiblingsNotFoundException("Siblings not found for "+this.getName());
        //     }
        // }

        public void validateMother() throws MemberNotFoundException {
            if(mother == null)
                throw new MemberNotFoundException("Mother not found for "+this.getName());
        }

        public void validateFather() throws MemberNotFoundException {
            if(father == null)
                throw new MemberNotFoundException("Father not found for "+this.getName());
        }

        // /**
        // * This method is used to get siblings of the person.
        // * @return siblings array list of all siblings
        // */
        // public ArrayList<FamilyMember> getSiblings() {

        //     if(father == null) return null;
        //     ArrayList<FamilyMember> siblings = father.getChildren();
        //     return siblings;
    
        // }


}
