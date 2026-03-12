package com.lpu.book_service.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.lpu.book_service.DTO.BookDTO;
import com.lpu.book_service.entity.Book;
import com.lpu.book_service.repository.BookRepository;
@Service
public class BookService {
	private ModelMapper modelMapper = new ModelMapper();;
	private BookRepository bookRepository;
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	public Book convertToEntity(BookDTO bookDTO) {
	    return modelMapper.map(bookDTO, Book.class);
	}
	public BookDTO convertToDTO(Book book) {
	    return modelMapper.map(book, BookDTO.class);
	}
	public List<BookDTO> convertToListDTO(List<Book> bookList){
		List<BookDTO> bookDTOList = new ArrayList<>();
		for(Book b:bookList) {
			bookDTOList.add(convertToDTO(b));
		}
		return bookDTOList;
	}
	public BookDTO saveBook(Book book) {
		return convertToDTO(bookRepository.save(book));
	}
	public BookDTO findByID(int id) {
		Book book = bookRepository.findById(id).orElse(null);
		return convertToDTO(book);
	}
	public String deleteByID(int id) {
		bookRepository.deleteById(id);
		return "Book deleted";
	}
	public List<BookDTO> findAll(){
		return convertToListDTO(bookRepository.findAll());
	}
	public BookDTO update(int id, BookDTO bookDTO) {
	    Book book = bookRepository.findById(id).get();
	    book.setTitle(bookDTO.getTitle());
	    book.setQuantity(bookDTO.getQuantity());
	    book.setPrice(bookDTO.getPrice());
	    return convertToDTO(bookRepository.save(book));
	}
	public BookDTO saveBookDTO(BookDTO book) {
		Book b = convertToEntity(book);
		return convertToDTO(bookRepository.save(b));
	}
}
