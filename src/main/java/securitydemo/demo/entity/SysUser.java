package securitydemo.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "user")
public class SysUser {
    
    @Id
    private Integer id;
    private String username;
    private String password;
    
}
