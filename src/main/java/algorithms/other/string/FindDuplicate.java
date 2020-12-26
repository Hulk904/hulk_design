package algorithms.other.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyuan on 2020/12/15.
 *
 * 609. 在系统中查找重复文件
 *
 * 给定一个目录信息列表，包括目录路径，以及该目录中的所有包含内容的文件，您需要找到文件系统中的所有重复文件组的路径。一组重复的文件至少包括二个具有完全相同内容的文件。

 */
public class FindDuplicate {

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap();
        for (String s:paths){
            String[] items = s.split("\\s");
            String path = items[0];
            for (int i = 1; i < items.length; i++){
                String cur = items[i];
                String name = cur.substring(0, cur.indexOf("("));
                String content = cur.substring(cur.indexOf("(") + 1, cur.length() - 1);
                if (map.get(content) == null){
                    List<String> l = new ArrayList();
                    l.add(path + "/" + name);
                    map.put(content, l);
                } else {
                    map.get(content).add(path + "/" + name);
                }
            }
        }
        List<List<String>> list = new ArrayList();
        for(Map.Entry<String, List<String>> en:map.entrySet()){
            if (en.getValue().size() > 1){
                list.add(en.getValue());
            }
        }
        return list;
    }
}
