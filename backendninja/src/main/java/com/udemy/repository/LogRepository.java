package com.udemy.repository;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Repository;

@Repository("logRepository")
public class LogRepository extends JpaRepository<Log,Serializable>{

}
