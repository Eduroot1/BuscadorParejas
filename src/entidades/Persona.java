/**
 * 
 */
package entidades;


/**
 * @author admin
 *
 */

public class Persona {

	/**Definicion de atributos*/
	public String nombre;
	public String apellidos;
	public int edad;
	public double peso;
	public Nacionalidades nacionalidad;
	public String idioma;
	public Genero sexo;
	public String orientacionSexual;
	public String descripcion;
	public String intereses;




	/**Constructor*/

	public Persona(String nombre, String apellidos, int edad, double peso,
			Nacionalidades nacionalidad, String idioma, Genero sexo, String orientacionSexual, String descripcion,
			String intereses) {

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.peso = peso;
		this.nacionalidad = nacionalidad;
		this.idioma = idioma;
		this.sexo = sexo;
		this.orientacionSexual = orientacionSexual;
		this.descripcion = descripcion;
		this.intereses = intereses;


	}




	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}




	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}




	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}




	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}




	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}




	/**
	 * @param peso the peso to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}




	/**
	 * @return the nacionalidad
	 */
	public Nacionalidades getNacionalidad() {
		return nacionalidad;
	}




	/**
	 * @param nacionalidad the nacionalidad to set
	 */
	public void setNacionalidad(Nacionalidades nacionalidad) {
		this.nacionalidad = nacionalidad;
	}




	/**
	 * @return the idioma
	 */
	public String getIdioma() {
		return idioma;
	}




	/**
	 * @param idioma the idioma to set
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}




	/**
	 * @return the sexo
	 */
	public Genero getSexo() {
		return sexo;
	}




	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}




	/**
	 * @return the orientacionSexual
	 */
	public String getOrientacionSexual() {
		return orientacionSexual;
	}




	/**
	 * @param orientacionSexual the orientacionSexual to set
	 */
	public void setOrientacionSexual(String orientacionSexual) {
		this.orientacionSexual = orientacionSexual;
	}




	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}




	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	/**
	 * @return the intereses
	 */
	public String getIntereses() {
		return intereses;
	}




	/**
	 * @param intereses the intereses to set
	 */
	public void setIntereses(String intereses) {
		this.intereses = intereses;
	}

	/**GET and SET*/


}
