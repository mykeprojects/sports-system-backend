package com.tournamentmanager.sports_system.service;

import com.tournamentmanager.sports_system.dto.user.CreateUserDTO;
import com.tournamentmanager.sports_system.dto.user.UpdateUserDTO;
import com.tournamentmanager.sports_system.dto.user.UserDetailResponseDTO;
import com.tournamentmanager.sports_system.dto.user.UserResponseDTO;
import com.tournamentmanager.sports_system.dto.user.UserSessionsResponseDTO;
import com.tournamentmanager.sports_system.dto.userrole.UserRolesResponseDTO;
import com.tournamentmanager.sports_system.entity.User;
import com.tournamentmanager.sports_system.exception.ApplicationException;
import com.tournamentmanager.sports_system.exception.ErrorCase;
import com.tournamentmanager.sports_system.mapper.UserMapper;
import com.tournamentmanager.sports_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service //decorador propio de los servicios
@RequiredArgsConstructor //Requiere constructor.
public class UserService {

    //inyección de variables de clase. Necesitamos una constante del repositorio
    private final UserRepository userRepository;
    // Necesitamos una constantee del UserMapper.
    //Patrón Singleton: Un objeto que va a ayudar a el servicio a funcionar.
    private final UserMapper userMapper;

    public UserResponseDTO create(CreateUserDTO dto) { //Hace las validacions necesarias en este momento.
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new ApplicationException(
                    ErrorCase.ALREADY_EXISTS,
                    "Ya existe un usuario con este email"
            );
        }
        User user = userMapper.toEntity(dto); //Lo paso a una entidad con el mapper
        User savedUser = userRepository.save(user); //Le pido al repositorio que me lo guarde.(save sirve para actualizar o para crear)
        //savedUser tiene id porque ahora me lo esta creando
        return userMapper.toResponseDTO(savedUser); //Me devuelve las fichas del usuario para que no me manda contraseñas
    }

    public List<UserResponseDTO> findAll() {
        List<User> users = userRepository.findAll(); //Busqueme todos los usuarios
        return userMapper.toResponseDTOList(users); //El mapper lo convierte en una lista de usuarios sin contraseñass
    }

    private User findUser(Long id) {
        return userRepository.findById(id) //buscamos un usuario en la base de datos
                .orElseThrow(() -> new ApplicationException(
                        ErrorCase.NOT_FOUND,
                        "Usuario no encontrado con id: " + id
                ));
    }
    //problema en el siguiente codigo: clase del martes
    public UserResponseDTO findById(Long id) {
        User user = findUser(id); //Llama a la función id user
        return userMapper.toResponseDTO(user);//responde con el usuario
    }

    public UserDetailResponseDTO findByIdAndProfile(Long id) {
        User user = userRepository
                .findWithProfileById(id)
                .orElseThrow(
                        () -> new ApplicationException(
                                ErrorCase.NOT_FOUND,
                                "Usuario no encontrado con id: " + id
                        )
                );

        return userMapper.toDetailResponseDTO(user);
    }

    public UserSessionsResponseDTO findByIdAndSessions(Long id) {
        User user = userRepository.findWithSessionsById(id)
                .orElseThrow(() -> new ApplicationException(
                        ErrorCase.NOT_FOUND,
                        "Usuario no encontrado con id: " + id
                ));
        return userMapper.toSessionsResponseDTO(user);
    }

    public UserRolesResponseDTO findByIdAndRoles(Long id) {
        User user = userRepository.findWithRolesById(id)
                .orElseThrow(() -> new ApplicationException(
                        ErrorCase.NOT_FOUND,
                        "Usuario no encontrado con id: " + id
                ));
        return userMapper.toRolesResponseDTO(user);
    }

    public UserResponseDTO update(Long id, UpdateUserDTO dto) {
        User user = findUser(id);
        if (userRepository.existsByEmailAndIdNot(dto.getEmail(), id)) {
            throw new ApplicationException(
                    ErrorCase.ALREADY_EXISTS,
                    "El email pertenece a otro usuario"
            );
        }
        userMapper.updateEntity(dto, user); //Pasan valores de la función por referencia
        User updatedUser = userRepository.save(user);
        return userMapper.toResponseDTO(updatedUser);
    }
    public void delete(Long id) {
        User user = findUser(id);
        userRepository.delete(user);
    }
}
