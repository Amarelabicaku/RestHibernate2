package RestHibernate2.RestHibernate2.Service;

import RestHibernate2.RestHibernate2.model.Pjese;

import java.util.List;

public interface PjeseService {
    Pjese savePjese(Pjese pjese);

    List<Pjese> getAllPjese();

    Pjese getPjeseById(long pjese_id);

    Pjese updatePjese(Pjese pjese, long pjese_id);

    void deletePjese(long pjese_id);
}
