public class AssociationMember extends Member {

    public AssociationMember(String user_name, String user_password, String user_id, String full_name) {
        super(user_name, user_password, user_id, full_name);
    }

    public void NewLeague(String LeagueName){
        AlphaSystem system = AlphaSystem.getSystem();
        system.AddtoDB(1,new League(LeagueName));
    }

    // currently not working
    public void AddSeasonToLeague(String LeagueName){
        AlphaSystem system = AlphaSystem.getSystem();
        system.AddtoDB(1,new League(LeagueName));
    }


}
