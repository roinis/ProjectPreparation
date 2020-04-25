import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TeamManagerTest {

    @Test
    public void teamManagerTest(){
        MemberStub member = new MemberStub("test", "12345", "12345", "test");
        boolean[] permissions1={true,true,true,true};
        TeamOwner teamOwner = new TeamOwner(member);
        Team team = new Team("hapoel", teamOwner, null);
        TeamManager teamManager=new TeamManager(member,null,null);
        teamManager.setTeam(team);
        assertEquals(team,teamManager.getTeam());
        teamManager.setPermissions(choosePermissions(permissions1));
        for(TeamManager.Permissions permissions: TeamManager.Permissions.values())
            assertTrue(teamManager.getPermissions().contains(permissions));
        teamManager.removeAllPermissions();
        assertTrue(teamManager.getPermissions().isEmpty());
    }

    public class MemberStub extends Member{
        public MemberStub(String user_name,String user_password,String user_id,String full_name){
            super(user_name,user_password, user_id, full_name);
            AlphaSystem alphaSystem=AlphaSystem.getSystem();
            alphaSystem.AddtoDB(2,this);
        }

    }

    private ArrayList<TeamManager.Permissions> choosePermissions(boolean[] permissionsList){
        ArrayList<TeamManager.Permissions> permissions=new ArrayList<>();
        if(permissionsList[0])
            permissions.add(TeamManager.Permissions.SET_TEAM_STATUS);
        if(permissionsList[1])
            permissions.add(TeamManager.Permissions.EDIT_PROPERTIES);
        if(permissionsList[2])
            permissions.add(TeamManager.Permissions.ADD_FINANCIAL_REPORT);
        if(permissionsList[3])
            permissions.add(TeamManager.Permissions.EDIT_PERSONAL_PAGE);
        return permissions;
    }

}
