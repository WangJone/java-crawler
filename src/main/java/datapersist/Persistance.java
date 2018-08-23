package datapersist;


import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * Two part:
 * one for creating a file
 * tow for persisting context to the file that created above
 */
public class Persistance {
    private String fileName =null;
    public Persistance()
    {
    }
    public Persistance(String fileName)
    {
        this.fileName = "persistance/"+fileName+".txt";
    }

    /**
     * Set the file name by aotomatic generation, divided two part
     * every single part have three digits,and the first for hero number ,the second for skin number
     * @param name
     * @param start
     * @param end
     * @param foot
     * @return
     */
    public List automaticGeneration(String name,int start, int end,int foot)
    {
        List<String> list = new LinkedList<String>();
        for(int i=start; i<=end; i+=foot)
        {
            for(int x=0;x<=15;x++) {
                list.add(name + String.valueOf(new DecimalFormat("000").format(i)+new DecimalFormat("000").format(x)));
            }
        }
        return list;
    }
    /**
     * To set file`s full name, eg:C:\\text.txt
     * @param fullname
     */
    public void setFullName(String fullname)
    {
        this.fileName = fullname;
    }
    public void setFileName(String name)
    {
        this.fileName = "persistance/"+name+".txt";
    }
}
