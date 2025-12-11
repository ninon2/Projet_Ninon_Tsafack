package com.example.Projet_Ninon_Tsafack.mapper;

import com.example.Projet_Ninon_Tsafack.dto.ClientDto;
import com.example.Projet_Ninon_Tsafack.dto.CreateClientDto;
import com.example.Projet_Ninon_Tsafack.dto.UpdateClientDto;
import com.example.Projet_Ninon_Tsafack.model.Client;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = CompteMapper.class)
public interface ClientMapper {
    @Mapping(target = "comptes", source = "comptes")
    ClientDto toDto(Client client);
    Client toEntity(CreateClientDto createClientDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateClientFromDto(UpdateClientDto updateClientDto, @MappingTarget Client client);
}
