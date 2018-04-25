package com.xs.selectimages.bean;

import com.xs.selectimages.utils.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 小松 2018/4/25
 */

public class FolderBean implements Serializable {

    private String name;
    private List<String> imageBeans;

    public FolderBean(String name) {
        this.name = name;
    }

    public FolderBean(String name, List<String> imageBeans) {
        this.name = name;
        this.imageBeans = imageBeans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImageBeans() {
        return imageBeans;
    }

    public void setImageBeans(List<String> imageBeans) {
        this.imageBeans = imageBeans;
    }

    public void addImage(String image) {
        if (image != null && !StringUtils.isEmpty(image)) {
            if (imageBeans == null) {
                imageBeans = new ArrayList<>();
            }
            imageBeans.add(image);
        }
    }

}
