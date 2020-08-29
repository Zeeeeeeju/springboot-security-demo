package securitydemo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import securitydemo.demo.entity.SysUser;

@Repository
public interface UserRepository extends JpaRepository<SysUser,Integer>{

    SysUser findUserByUsername(String username);

}
