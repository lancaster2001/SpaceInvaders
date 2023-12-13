public class invaderFactory {
    private static invaderFactory instance;
    public static invaderFactory getInstance() {
        if(instance == null) {
            instance = new invaderFactory();
        }
        return instance;
    }
    public invader getInvader(String invaderType){
        if(invaderType == null){
            return null;
        }
        if(invaderType.equalsIgnoreCase("SMALL")){
           return new SmallInvader();

        } else if(invaderType.equalsIgnoreCase("MEDIUM")){
            return new MediumInvader();

        } else if(invaderType.equalsIgnoreCase("LARGE")){
            return new LargeInvader();
        }

        return null;
    }
}