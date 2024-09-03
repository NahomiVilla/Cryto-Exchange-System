# CryptoSystem

## Descripción

**CryptoSystem** es un sistema de gestión de criptomonedas que permite a los usuarios realizar transacciones de compra y venta de criptomonedas, administrar sus carteras digitales, y ver su historial de transacciones. El sistema simula un mercado con fluctuaciones de precios de criptomonedas, específicamente Bitcoin (BTC) y Ethereum (ETH), que varían en tiempo real.

## Características

- **Autenticación de Usuarios**: Registro, inicio y cierre de sesión de usuarios.
- **Gestión de Criptomonedas**: Compra y venta de Bitcoin y Ethereum.
- **Historial de Transacciones**: Los usuarios pueden ver su historial de transacciones.
- **Gestión de Carteras**: Los usuarios pueden ver sus balances de dinero fiat y criptomonedas.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Maven**: Herramienta de gestión de proyectos y dependencias.
- **Lombok**: Librería para reducir el código repetitivo como getters, setters, y constructores.

## Estructura del Proyecto

El proyecto sigue la arquitectura MVC (Modelo-Vista-Controlador) y está organizado en los siguientes paquetes:

- **com.CryptoSystem.model**: Contiene las clases principales del modelo como `Users`, `Wallet`, `Crypto`, `Transaction`, `Order`, `PurchaseOrder`, `SellOrder`,`Authentication`, y `OrderBook`.
- **com.CryptoSystem.vistas**: Contiene las vistas que interactúan con el usuario como `TransactionView`,`MainMenuView`,`UserView` y `AuthenticationView`.
- **com.CryptoSystem.controllers**: Contiene los controladores que manejan la lógica de negocio, incluyendo `UserController`, `TransactionController`, y `OrderBookController`.
- **com.CryptoSystem.interfaces**: Contiene las interfaces `AuthenticationInterface`, `TransactionInterface`, y `UserInterface`.

## Instalación

### Prerrequisitos

- **Java 8 o superior**
- **Apache Maven 3.9.6**
- **Lombok**
- 
### Uso
## Registro de Usuarios
Al iniciar la aplicación, los usuarios pueden registrarse proporcionando un nombre, correo electrónico y contraseña.
## Inicio de Sesión
Los usuarios registrados pueden iniciar sesión con su correo electrónico y contraseña.

## Gestión de Criptomonedas
Una vez autenticado, el usuario puede:
- **Comprar Criptomonedas**: El usuario puede comprar Bitcoin o Ethereum usando dinero fiat disponible en su cartera ya sea por medio de una orden de compra o por compra direacta.
- **Vender Criptomonedas**: El usuario puede vender criptomonedas disponibles en su cartera.
- **Ver Saldo**: El usuario puede ver el saldo actual en dinero fiat y criptomonedas.
- **Ver Historial de Transacciones**: El usuario puede ver todas las transacciones realizadas en su cuenta.

### Clonar el Repositorio

```bash
git clone https://github.com/NahomiVilla/CryptoSystem.git
cd CryptoSystem
```
