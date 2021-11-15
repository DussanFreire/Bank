# Proceso de creación y ejecución
## Se comenzó el proceso de creación con la configuración de J Unit 
* Se creó una carpeta test donde estarán todos los archivos de tests.
* En la carpeta de los tests, damos clic derecho y seleccionamos New > Junit test case.
* Le ponemos el nombre al test en el campo de texto “Name”.
* Hicimos click en Finish y se verá el test creado en el folder escogido.
## Para la parte de ejecución  se configura Jacoco para ver de manera adecuada el coverage
* Ahora, para hacer correr los tests y ver el coverage del código hacemos click en el segundo botón de play y configuramos el coverage del proyecto.
* Seleccionamos la opción “run all tests in the selected project, package or source folder” para que así nos muestre el coverage completo.
* Se mostrará en la consola el número de tests ejecutados, pasados, fallidos y saltados.
# Resultados

Se obtuvo como resultado un total de 81.8% de coverage, donde el 18.2% restante casi en su totalidad pertenece a métodos de búsqueda alternativos que todavía no están siendo utilizados en la aplicación, además de múltiples archivos que contienen las variables constantes utilizadas en el programa. 
Sin embargo se procuró obtener el máximo coverage en los módulos de mayor importancia del programas los cuales serían: Account, bank y bank Manager. De esta manera se optimizó el tiempo enfocando el tiempo del sprint en corroborar el correcto funcionamiento de los módulos más importantes. 
Es en este sentido que se cree que se obtuvieron los resultados correctos. 

# ESTRUCTURA DEL CODIGO
## S.O.L.I.D.

### Single Responsibility Principle.-

In general, this principle was applied in almost the entire project, specifically creating a new class: BankOperator, to reduce the load on the Bank class.

### Open-Close Principle.-

The IWithdrawMoney interface and the abstract classes No commission and commission were created to be able to keep open the extension of being able to add different types of accounts, but closed to the modification of the account types that already exist.

### Liskov Substitution Principle.-

In the same way, the No commission and commission classes were created in order not to alter the current types of accounts with future system updates such as creating new ones or updating them.

### Interface Segregation Principle.-

The interface: IWithdrawMoney was created in order to have to create this method in classes that did not use it as was the case with HousingAccount, which previously had to be implemented since it inherited that method from the account class, but now only the accounts that They need it, implement it and those that don't, shouldn't.

## Dependency Inversion Principle.-

The part of the bank that handled everything was divided into modules and created a high level of dependency, in addition to separating in the same way the types of accounts that previously all depended on a single class.

# REFERENCIAS
Informe del Codigo : https://docs.google.com/document/d/1buC5zROhoB11TnzNdj1LYlQdBLAEp-mD4scKg1dxlGE/edit?usp=sharing