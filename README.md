
# A3 2ⁿᵈ Semester
My university second semester assessment project.

# 1 MAIN OBJECTIVES
• Make the integration of the consult API in the main app.
• Create a simple and intuitive user interface with a table for displaying data and an editing screen for already registered records.
• Create a database capable of meeting the application's needs.
<BR><BR>
# 2 DEVELOPMENT
This section tell a bit of the process of creating this project, here you'll find the tools, classes, libraries and documentation that was used for the creation of this project.
<br><BR>

## 2.1 SOFTWARES

For the produce of the documents I used Microsoft Word,  for the presentations I used Microsoft PowerPoint along with OBS for recording the presentation, The database that I used was MySql with PHPMyAdmin used as DBMS, The creation of the diagrams was done with Dia Diagram, and all the code was produced with eclipse together with the libraries Swing(Interface Creation), WindowBuilder(GUI for creating graphical interfaces), GSON(JSON String Formatting), JSoup (Performs data collection on the web).
<BR><BR>

## 2.2 CLASSES AND METHODS
In the application there are 5 classes, 2 of which are graphical interfaces, 1 auxiliary class known as BEAN, 1 class for bank actions and the last one for consulting the API.

The first class of graphical interface is responsible for showing all the registered clients, in addition to allowing the entry of new clients through a query made using the API, it is also possible to access a popup menu by pressing the right mouse button on top of a line in the table, this popup allows the deletion of such a line, or access the second interface, which is responsible for editing the data. There the data of the main table is expanded and there you have the option to edit or delete the registry.

The BEAN auxiliary class is a very used class in JAVA, it is a class for transmitting information between classes. The BEAN is composed of private variables with GET and SET methods for the respective variables.

The database class is standard with a database connection method, a connection STRING in addition to the standard INSERT, DELETE, UPDATE and READ methods, but in addition to the standards my class adds the READCNPJ method, which is a method used by the registry editing class mentioned in the second paragraph.

Finally, the web query class communicates with the api, returns a JSON string that can be used with the GSON library for parsing the information and storing it into ARRAYS.
<BR><BR>
## 2.3 DATABASE
	 
### 2.3.1 DATA QUERYS

•Data Insert
```JAVA
public static void insert (String NomeFantasia, String RazaoSocial, String CNPJ, String CNAE, String CNAECodigo, String CEP, String Abertura, String Telefone, String Email, String Logradouro, String status) 
{
    String sql = "INSERT INTO `atributos` (`NomeFantasia`, `RazaoSocial`, `CNPJ`, `CNAE`, `CNAECodigo`,`CEP`, `Abertura`, `Telefone`, `Email`, `Logradouro`, `status`) "+ "VALUES ('" + NomeFantasia 
    + "','" + RazaoSocial + "','" + CNPJ + "','" + CNAE + "','" + CNAECodigo + "','" + CEP + "','" 
    + Abertura + "','" + Telefone + "','" + Email + "','" + Logradouro + "','" + status + "');";
    exec(sql);
}
```
<BR>
•Data Deletion

```JAVA
public static void delete (String id) 
{
    String sql = "DELETE FROM `atributos` WHERE CNPJ ='" + id + "';";
    exec(sql);
}
```
<br>

•Data Edition
```java
public static void update(String NomeFantasia, String RazaoSocial, String CNPJ, String CNAE, String CNAECodigo, String CEP, String Abertura, String Telefone, String Email, String Logradouro) 
{
    String sql = "UPDATE atributos " + "SET NomeFantasia = '" + NomeFantasia + "', RazaoSocial = '" +   
    RazaoSocial + "', CNPJ ='" + CNPJ + "', CNAE = '" +CNAE + "', CNAECodigo = '" + CNAECodigo 
    + "', CEP = '" + CEP + "', Abertura = '" + Abertura + "', Telefone = '" + Telefone 
    + "', Email = '"   + Email + "', Logradouro = '" + Logradouro + "'  WHERE CNPJ ='" + CNPJ + "';";
    exec(sql);
}
```

<br>

 •Data Reading
```
public List<Atributos> read()
{
    List<Atributos> atributos = new ArrayList<>();
    try {
	    ResultSet rs = conectar().prepareStatement("SELECT * FROM atributos").executeQuery();	     
	    while(rs.next()) {
		Atributos atributo = new Atributos();
		
        atributo.setNomeFantasia(rs.getString(2));
	    atributo.setRazaoSocial(rs.getString(3));
        atributo.setCNPJ(rs.getString(4));
	    atributo.setCNAE(rs.getString(5));
	    atributo.setCNAECodigo(rs.getString(6));
	    atributo.setCEP(rs.getString(7));
	    atributo.setAbertura(rs.getString(8));
	    atributo.setTelefone(rs.getString(9));
	    atributo.setEmail(rs.getString(10));
	    atributo.setLogradouro(rs.getString(11));
	    atributo.setstatus(rs.getString(12));
	    
	    atributos.add(atributo);
	    }
	} catch (Exception e) {
	}
return atributos;		
}
```
<br>

## 2.4 DIAGRAMAS
### 2.4.1 USE CASE

![Class diagram](https://github.com/GuilhermeMendes1503/A3_2Semester/blob/main/Diagrams/DiagramaDeCasodeUso.png?raw=true?raw=true)

### 2.4.2 CLASS 

![Class diagram](https://github.com/GuilhermeMendes1503/A3_2Semester/blob/main/Diagrams/DiagramaDeClasse.png?raw=true)

### 2.4.3 ATIVIDADES


![alt text](https://github.com/GuilhermeMendes1503/A3_2Semester/blob/main/Diagrams/DiagramaDeAtividades.png?raw=true)

### 2.4.4 SEQUENCE
#### 	• Edition or removal
 
![Class diagram](https://github.com/GuilhermeMendes1503/A3_2Semester/blob/main/Diagrams/DiagramaSequenciaEdi%C3%A7%C3%A3oRemo%C3%A7%C3%A3o.png?raw=true?raw=true)


####	• Consult

![Class diagram](https://github.com/GuilhermeMendes1503/A3_2Semester/blob/main/Diagrams/DiagramaSequenciaConsulta.png?raw=true?raw=true) 

### 2.4.5 DATABASE
 
 ![Class diagram](https://github.com/GuilhermeMendes1503/A3_2Semester/blob/main/Database_Iteractions/MER.png?raw=true?raw=true)

## 2.8 REQUISITOS FUNCIONAIS E NÃO FUNCIONAIS
### 2.8.1 REQUISITOS FUNCIONAIS
•RF1 – O sistema deve permitir a exclusão de fichas;<BR>
•RF2 – O sistema deve permitir a edição de fichas;
•RF3 – O sistema deve mostrar as fichas cadastradas;
•RF4 – O sistema deve armazenar as fichas;
•RF5 – O sistema deve realizar a inserção de fichas a partir do CNPJ informado
<BR>
### 2.8.2 REQUISITOS NÃO FUNCIONAIS
•RNF1 – O aplicativo deverá aceitar todos os dados padrões do CNPJ;
•RNF2 – A interface terá que ser limpa e fácil de utilizar;
•RNF3 – O aplicativo tem como foco o Sistema operacional Windows;
•RNF4 – O aplicativo será feito com em JAVA com o banco em SQL;
•RNF5 – O Aplicativo terá inserção de dados apenas pela API para evitar dados incorretos.
