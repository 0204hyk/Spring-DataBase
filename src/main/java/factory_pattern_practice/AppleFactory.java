package factory_pattern_practice;

import lombok.ToString;

public class AppleFactory {

	AppleConfig config;
	
	public void setConfig(AppleConfig config) {
		this.config = config;
	}
	
	public Apple getApple() {
		return new RealApple(config);
	}
	
	@ToString
	class RealApple implements Apple {
		
		private String color;
		private int price;
		
		RealApple(AppleConfig config) {
			this.color = config.getColor();
			this.price = config.getPrice();
		}
		
		@Override
		public String getColor() {
			return color;
		}

		@Override
		public int getPrice() {
			return price;
		}
		
	}
	
}
