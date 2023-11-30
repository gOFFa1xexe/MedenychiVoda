package dao;

import Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedenychiDAO extends JpaRepository<User,Long > {

}
