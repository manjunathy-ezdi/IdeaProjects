package com.springapp.misc;

import java.util.ArrayList;

/**
 * Created by EZDI\manjunath.y on 28/1/16.
 */

public class RandomObject {

    int id=-1;
    String name="Sher Khan";
    ArrayList<String> children;

    public void populate(int id, String name, ArrayList<String> children){
        this.id=id;
        if(name!=null && !name.isEmpty()) this.name=name;
        if(children!=null && children.size()>0) this.children=children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<String> children) {
        this.children = children;
    }

    public String toJSON(){
        StringBuffer ret = new StringBuffer("{");
        ret.append("id:"+id);
        if(name!=null) ret.append(",\n"+"name:"+name);
        if(children!=null){
            ret.append(",\nchildren:{\n");

            for(String each:children){
                ret.append(each+",");
            }
            ret.append("}\n");
        }
        ret.append("}");
        return ret.toString();
    }
}
