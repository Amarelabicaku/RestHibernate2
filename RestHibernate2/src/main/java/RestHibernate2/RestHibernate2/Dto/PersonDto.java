package RestHibernate2.RestHibernate2.Dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class PersonDto {
    private long laptopid;
private long price;
    private String name;

    private List<String> person = new ArrayList<>();




}
