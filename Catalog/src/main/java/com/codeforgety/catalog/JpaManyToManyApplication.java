package com.codeforgety.catalog;

import com.codeforgety.catalog.model.Book;
import com.codeforgety.catalog.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JpaManyToManyApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext=
				SpringApplication.run(JpaManyToManyApplication.class, args);

		BookRepository bRepository =
				configurableApplicationContext.getBean(BookRepository.class);



		Book book1=new Book("How to get a good grade in DOS in 40 minutes a day"," distributed systems",10,10.0);
		Book book2=new Book("RPCs for Noobs"," distributed systems",10,10.0);
		Book book3=new Book("Xen and the Art of Surviving Undergraduate School"," undergraduate school",10,10.0);
		Book book4=new Book("Cooking for the Impatient Undergrad"," undergraduate school",10,10.0);

		bRepository.save(book1);
		bRepository.save(book2);
		bRepository.save(book3);
		bRepository.save(book4);


//		List<Stream> streams=Arrays.asList(cooking,gaming);
//
//		streamRepository.saveAll(streams);
//
//		johnViewer.followStream(cooking);
//		willViewer.followStream(gaming);
//		yazViewer.followStream(gaming);
//		yazViewer.followStream(cooking);
//
//		viewerRepository.saveAll(viewers);



	}

}
