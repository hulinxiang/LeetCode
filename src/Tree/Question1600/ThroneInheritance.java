package Tree.Question1600;


import java.util.*;

public class ThroneInheritance {
    Map<String,List<String>> edges;
    Set<String> dead;
    String king;


    public ThroneInheritance(String kingName) {
        edges=new HashMap<>();
        dead=new HashSet<>();
        king=kingName;
    }

    public void birth(String parentName, String childName) {
        List<String> children=edges.getOrDefault(parentName, new ArrayList<>());
        children.add(childName);
        edges.put(parentName,children);
    }



    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> ans=new ArrayList<>();
        preorder(ans,king);
        return ans;
    }

    public void preorder(List<String> ans, String name){
        if(!dead.contains(name)){
            ans.add(name);
        }
        List<String> children=edges.getOrDefault(name,new ArrayList<>());
        for (String childName:children){
            preorder(ans,childName);
        }
    }



    public static void main(String[] args) {
        ThroneInheritance t=new ThroneInheritance("king");
        t.birth("king", "andy"); // 继承顺序：king > andy
        t.birth("king", "bob"); // 继承顺序：king > andy > bob
        t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
        t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
//        t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
//        t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
//        t.getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
//        t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
//        t.getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]
        System.out.println(t.getInheritanceOrder());
    }

}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
