package com.zappts.Controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.zappts.Models.MagicGatheringModel;
import com.zappts.Repository.MagicRepository;

@RestController
public class ControllerMagicGathering {

	private MagicRepository magicRepository;
	
	public ControllerMagicGathering(MagicRepository magicRepository) {
		this.magicRepository = magicRepository;
	}
	
	@GetMapping("/magic")
	public List<MagicGatheringModel> findAll(){
		return StreamSupport.stream(magicRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
	}
	
	@GetMapping("/magic/{id}")
	public MagicGatheringModel findById(@PathVariable("{id}") Long id) {
		return magicRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/magic")
	public MagicGatheringModel save(@Valid @RequestBody MagicGatheringModel magicgatheringmodel) {
		return magicRepository.save(magicgatheringmodel);
	}
	
	@PutMapping("/magic/{id}")
	public MagicGatheringModel update (@Valid @RequestBody MagicGatheringModel magicgatheringmodel, @PathVariable("id") Long id  ) {
		findById(id);
		magicgatheringmodel.setId(id);
		return magicRepository.save(magicgatheringmodel);
	}
	
	@PatchMapping("/expense/{id}")
	public MagicGatheringModel patchUpdate(@RequestBody MagicGatheringModel magicgatheringmodel, @PathVariable ("id") Long id) throws IllegalAccessException, InvocationTargetException{
		MagicGatheringModel existingMagic = findById(id);
		
		BeanUtils.copyProperty(existingMagic,null, magicRepository);
		System.out.println(existingMagic);
		return magicRepository.save(magicgatheringmodel);
		
	}
	
	@DeleteMapping("/magic/{id}")
	public void delete(@PathVariable ("id")Long id ) {
		findById(id);
		
		magicRepository.deleteById(id);
	}
	
	
}
