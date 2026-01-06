package dogs;

public class Dog {
	private String breed;
	private double lifeExpectency;
	private double weight;
	private double height;
	private String countryOfOrigin;
	private String colour;
	
	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}
	/**
	 * @param breed the breed to set
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}
	/**
	 * @return the lifeExpectency
	 */
	public double getLifeExpectency() {
		return lifeExpectency;
	}
	/**
	 * @param lifeExpectency the lifeExpectency to set
	 */
	public void setLifeExpectency(double lifeExpectency) {
		this.lifeExpectency = lifeExpectency;
	}
	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	 * @return the countryOfOrigin
	 */
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
	/**
	 * @param countryOfOrigin the countryOfOrigin to set
	 */
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	/**
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}
	/**
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public void displayAll() {
		System.out.println("Dog Breed      :"+this.breed );
		System.out.printf("Average Weight :%.2f\n",this.weight);
		System.out.printf("Average Height :%.2f\n",this.height);
		System.out.println("Origin Country :"+this.countryOfOrigin);
		System.out.println("Colour         :"+this.colour);
		System.out.println();
	}
}
