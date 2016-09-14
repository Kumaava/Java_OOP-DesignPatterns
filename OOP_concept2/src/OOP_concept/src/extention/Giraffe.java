package OOP_concept.src.extention;

public class Giraffe extends Creature{
        
	    private String name;
	
        @Override	
		public void setName(String newName) {
			// TODO Auto-generated method stub
			name = newName;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return name;
		}

		@Override
		public void setHeight(double newheight) {
			// TODO Auto-generated method stub
			height = newheight;
		}

		@Override
		public double getHeight() {
			// TODO Auto-generated method stub
			return height;
		}

		@Override
		public void setWeight(double newWeight) {
			// TODO Auto-generated method stub
			weight = newWeight;
		}

		@Override
		public double getWeight() {
			// TODO Auto-generated method stub
			return weight;
		}

		@Override
		public void setFavFood(String newFood) {
			// TODO Auto-generated method stub
			favFood = newFood;
		}

		@Override
		public String getFavFood() {
			// TODO Auto-generated method stub
			return favFood;
		}

		@Override
		public void setSpeed(double newSpeed) {
			// TODO Auto-generated method stub
			speed = newSpeed;
			
		}

		@Override
		public double getSpeed() {
			// TODO Auto-generated method stub
			return speed;
		}

		@Override
		public void setSound(String newSound) {
			// TODO Auto-generated method stub
			sound = newSound;
		}

		@Override
		public String getSound() {
			// TODO Auto-generated method stub
			return sound;
		}
	}

