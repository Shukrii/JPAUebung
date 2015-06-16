package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
@Import(Config.class)
public class JpaUebungApplication implements CommandLineRunner {
    
    @Autowired
    
    
    public static void main(String[] args)
    {
        SpringApplication.run(JpaUebungApplication.class, args);
    }
    
    @Override
    @Transactional
    public void run(String... arg0) throws Exception
    {
        
        
    }
    
    
}