/**
 * 
 */
package beer;

/**
 * 
 */
public class Beer {
	//Beer Name,Beer Style,Country,Alcohol Percentage
	private String name;
	private String style;
	private String country;
	private double percentage;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}
	/**
	 * @param style the style to set
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the percentage
	 */
	public double getPercentage() {
		return percentage;
	}
	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	public void displayAll() {
		System.out.println("Beer Name: "+this.name);
		System.out.println("Style:     "+this.style);
		System.out.println("Country:   "+this.country);
		 System.out.printf("Percentage:%.2f%%\n",this.percentage);
		 System.out.println();
	}


}
