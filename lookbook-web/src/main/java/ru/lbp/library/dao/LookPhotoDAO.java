package ru.lbp.library.dao;

import org.springframework.stereotype.Repository;
import ru.lbp.library.domain.Look;
import ru.lbp.library.domain.LookPhoto;

/**
 *
 * @author gorelov-n
 */
@Repository

public class LookPhotoDAO extends ElementDAO<LookPhoto>
{
    public LookPhotoDAO(){
        super(LookPhoto.class);
    }   

    public void deleteByLookId(Look lookId){
        session().createQuery("delete from LookPhoto where lookId = :lookId").
                setParameter("lookId", lookId).
                executeUpdate();  
    }
}
