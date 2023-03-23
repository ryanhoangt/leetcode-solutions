// Question: https://leetcode.com/problems/throne-inheritance
// Created on: 2023-03-21

public class ThroneInheritance {

    private String kingName;
    private Map<String, List<String>> parentToChidrens;
    private Set<String> deadSet;
    private List<String> inheritanceOrder;

    public ThroneInheritance(String kingName) {
        this.parentToChidrens = new HashMap<>();
        this.kingName = kingName;
        this.deadSet = new HashSet<>();
    }
    
    public void birth(String parentName, String childName) {
        if (parentToChidrens.get(parentName) == null)
            parentToChidrens.put(parentName, new ArrayList<>());

        parentToChidrens.get(parentName).add(childName);
    }
    
    public void death(String name) {
        deadSet.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        this.inheritanceOrder = new ArrayList<>();
        preOrder(kingName);

        return inheritanceOrder;
    }

    private void preOrder(String parent) {
        if (!deadSet.contains(parent)) inheritanceOrder.add(parent);

        if (parentToChidrens.get(parent) == null) return;
        for (int i = 0; i < parentToChidrens.get(parent).size(); i++) {
            preOrder(parentToChidrens.get(parent).get(i));
        }
    }
    
}
