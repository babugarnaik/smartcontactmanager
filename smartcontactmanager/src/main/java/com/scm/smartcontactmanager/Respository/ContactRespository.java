package com.scm.smartcontactmanager.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

public interface ContactRespository<T> extends JpaRepository<T,ID>{

}
