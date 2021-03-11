package family.service.relationship;

import java.util.ArrayList;

import family.FamilyMember;

abstract class Relationship {

    public boolean isNull(Object o){
        return o == null;
    }


    public ArrayList<String> getAllMembersFromArrayBasedOnGender(ArrayList<FamilyMember> members, String gender){
        ArrayList<String> result = new ArrayList<>();
        
        for(FamilyMember member: members){
            String memberName = member.getName();
            String memberGender = member.getGender();
            if(memberGender.equals(gender)){
                result.add(memberName);
            }    
        }

        return result;
    }

    public ArrayList<String> getAllMembersFromArrayExceptOne(ArrayList<FamilyMember> members, String name){
        ArrayList<String> result = new ArrayList<>();
        
        for(FamilyMember member: members){
            String memberName = member.getName();
            if(!memberName.equals(name)){
                result.add(memberName);
            }    
        }

        return result;
    }

    public ArrayList<String> getAllMembersFromArrayBasedOnNameAndGender(ArrayList<FamilyMember> members, String nameToExclude, String gender){
        ArrayList<String> result = new ArrayList<>();
        
        for(FamilyMember member: members){
            String memberName = member.getName();
            String memberGender = member.getGender();
            if(!memberName.equals(nameToExclude) && memberGender.equals(gender)){
                result.add(memberName);
            }    
        }

        return result;
    }

    public ArrayList<String> getAllSpousesOfMembersBasedOnGender(ArrayList<FamilyMember> members, String gender){
        ArrayList<String> result = new ArrayList<>();
        
        for(FamilyMember member: members){
            if(member.isMarried()){
                FamilyMember spouse = member.getSpouse();
                String memberName = spouse.getName();
                String memberGender = spouse.getGender();
                if(memberGender.equals(gender)){
                    result.add(memberName);
                }  
            }
        }
        return result;
    }

    public ArrayList<String> getAllMembers(ArrayList<FamilyMember> members){
        ArrayList<String> result = new ArrayList<>();
        
        for(FamilyMember member: members){
            String memberName = member.getName();
            result.add(memberName);   
        }

        return result;
    }


    abstract public ArrayList<String> getPeople(FamilyMember member);

    


}
