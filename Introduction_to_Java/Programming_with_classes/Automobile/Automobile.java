public class Automobile {
    private int id;
    private String brand;
    private boolean moving; //false - автомобиль стоит на месте, true - автомобиль движется.
    private Engine engine;
    private Wheel[] wheels;
    private int numberOfWeel;
    private int wheelMount;
    private double tankCapacity;
    private double fuelValue;
    private static int lastID;

    {
        lastID = 0;
    }

    public Automobile() {
        this.id = lastID + 1;
        lastID++;
        this.engine = null;
        this.numberOfWeel = 4;
        this.wheelMount = 1;
        this.wheels = new Wheel[4];
        this.tankCapacity = 60;
        this.fuelValue = 0;
        this.moving = false;
    }

    public Automobile(String brand, Engine engine, Wheel[] wheels, int numberOfWheel, int wheelMount, int tankCapacity) {
        this.id = lastID;
        lastID++;
        this.brand = brand;
        installEngine(engine);
        this.numberOfWeel = numberOfWheel;
        this.wheelMount = wheelMount;
        this.wheels = new Wheel[this.numberOfWeel];
        for (int i = 0; i < wheels.length; i++) {
            installWheel(wheels[i], i);
        }
        this.tankCapacity = tankCapacity;
        this.moving = false;
    }

    public int getWheelMount() {
        return wheelMount;
    }

    public boolean isMoving() {
        return moving;
    }

    /*
     * устанавливает монтажный размер колес для автомобиля
     * изменение монтажного размера колеса может быть осуществлено
     * только при отсутствии установленных колес на автомобиле
     * возвращает статус операции:
     * */
    public String setWheelMount(int wheelMount) {
        boolean flag = true;
        String res;
        for (int i = 0; i < this.wheels.length; i++) {
            if (this.wheels[i] != null) {
                flag = false;
                break;
            }
        }
        if (flag) {
            this.wheelMount = wheelMount;
            res = "*смена монтажного размера прошла успешно*";
        } else {
            res = "*на автомобиле есть установленные колеса*";
        }
        return res;
    }

    /*
     * метод демонтирует колесо с указанного места.
     * возвращает статус операции
     * */
    public String removeWheel(int place) {
        String res;
        if (place >= 0 && place < this.numberOfWeel) {
            if (this.wheels[place] != null) {
                if (!this.engine.isStarted()) {
                    if (!this.isMoving()) {
                        this.wheels[place].setMountedIn(null);
                        this.wheels[place] = null;
                        res = "*колесо успешно демонтировано*";
                    } else {
                        res = "*автомобиль движется*";
                    }
                } else {
                    res = "*у автомобиля работает двигатель*";
                }
            } else {
                res = "*на этом месте уже нет колеса*";
            }
        } else {
            res = "*указано неверное место установки колеса*";
        }
        return res;
    }

    /*
     * метод устанавливает колесо на указанное место
     * возвращает статус выполнения операции
     * */
    public String installWheel(Wheel wheel, int instPlace) {
        String res;
        if (instPlace >= 0 && instPlace < this.numberOfWeel) {
            if (wheel.getMountedIn() == null) {
                if (wheel.getMountType() == this.wheelMount) {
                    if (this.wheels[instPlace] == null) {
                        this.wheels[instPlace] = wheel;
                        wheel.setMountedIn(this);
                        res = "*колесо установлено успешно*";
                    } else {
                        res = "*на этом месте уже установлено колесо*";
                    }
                } else {
                    res = "*колесо не подходит по геометрии*";
                }
            } else {
                res = "*колесо уже где - то установлено*";
            }
        } else {
            res = "*указано неверное место установки колеса*";
        }
        return res;
    }

    /*
     * заменяет колесо на автомобиле
     * возвращает статус операции
     * */
    public String changeWheel(Wheel wheel, int place) {
        String res;
        boolean removed;
        if (isWheelInstalled(place)) {
            String removeRes = removeWheel(place);
            if (removeRes.equals("*колесо успешно демонтировано*")) {
                removed = true;
                res = "колесо демонтировано";
                //res = installWheel(wheel, place) == "*колесо установлено успешно*" ? "*колесо заменено успешно" : "не удалось установить новое колесо";
            } else {
                res = "*не удалось снять старое колесо" + removeRes;
                removed = false;
            }
        } else {
            removed = true;
            res = "колесо демонтировано";
            //res = installWheel(wheel, place) == "*колесо установлено успешно*" ? "*колесо заменено успешно" : "не удалось установить новое колесо";
        }
        if (res.equals("колесо демонтировано")) {
            String installRes = installWheel(wheel, place);
            res = installRes.equals("*колесо установлено успешно*") ? "*колесо заменено успешно*" : "*не удалось установить новое колесо" + installRes;
        }
        return res;
    }

    /*
     * устанавливает двигатель на автомобиль
     * возвращает статус операции
     * */
    public String installEngine(Engine engin) {
        String res;
        if (engin.getInstalledIn() == null) {
            if (this.engine == null) {
                engin.stopEngine();
                this.engine = engin;
                engin.setInstalledIn(this);
                res = "*двигатель установлен успешно*";
            } else {
                res = "*на автомобиле уже установлен двигатель*";
            }
        } else {
            res = "этот двигатель уже где-то установлен";
        }
        return res;
    }

    /*
     * снимает с автомобиля двигатель
     * возвращает статус операции
     * */
    public String removeEngine() {
        String res;
        if (this.engine != null) {
            this.engine.stopEngine();
            this.engine.setInstalledIn(null);
            this.engine = null;
            res = "двигатель снят успешно";
        } else {
            res = "*на автомобиле уже нет двигателя*";
        }
        return res;
    }

    /*
     *проверяет установлен ли двигатель
     * */
    public boolean isEngineInstall() {
        boolean res;
        if (this.engine == null) {
            res = false;
        } else {
            res = true;
        }
        return res;
    }

    /*
     *проверяет установлены ли все колеса
     * */
    public boolean isWheelsInstalled() {
        boolean res = true;
        for (int i = 0; i < this.wheels.length; i++) {
            if (this.wheels[i] == null) {
                res = false;
                break;
            }
        }
        return res;
    }

    public boolean isWheelInstalled(int place) {
        boolean res;
        if (place >= 0 && place < numberOfWeel) {
            if (wheels[place] != null) {
                res = true;
            } else {
                res = false;
            }
        } else {
            res = false;
        }
        return res;
    }

    /*
     *начинает движение автомобиля
     * возвращает статус операции
     * */
    public String startMoving() {
        String res;
        if (!this.isMoving()) {
            if (this.isWheelsInstalled()) {
                if (this.isEngineInstall()) {
                    if (this.engine.isStarted()) {
                        this.moving = true;
                        res = "*движение начато успешно*";
                    } else {
                        res = "*двигатель не запущен*";
                    }
                } else {
                    res = "*двигатель не установлен*";
                }
            } else {
                res = "*не все колеса установлены*";
            }
        } else {
            res = "*автомобиль уже движется*";
        }
        return res;
    }

    /*
     * останавливает движение автомобиля
     * возвращает статус операции
     * */
    public String stopMoving() {
        String res;
        if (this.isMoving()) {
            this.moving = false;
            res = "движение остановлено успешно";
        } else {
            res = "автомобиль уже не движется";
        }
        return res;
    }

    /*
     * запускает двигатель на автомобиле
     * возвращает статус операции
     * */
    public String startEngine() {
        String res;
        if (this.isEngineInstall()) {
            if (fuelValue > 0) {
                if (!this.engine.isStarted()) {
                    this.engine.startEngine();
                    if (this.engine.isStarted()) {
                        res = "*двигатель успешно запущен*";
                    } else {
                        res = "*двигатель не завелся*";
                    }
                } else {
                    res = "*двигатель уже работает*";
                }
            } else {
                res = "*нет топлива*";
            }
        } else {
            res = "*на автомобиле нет двигателя*";
        }
        return res;
    }

    /*
     * останавливает двигатель на автомобиле
     * возвращает статус операции
     * */
    public String stopEngine() {
        String res;
        if (engine.isStarted()) {
            if (!isMoving()) {
                engine.stopEngine();
                if (!engine.isStarted()) {
                    res = "*двигатель успешно остановлен*";
                } else {
                    res = "*двигатель все еще работает*";
                }
            } else {
                res = "*автомобиль движется*";
            }
        } else {
            res = "*двигатель уже остановлен*";
        }
        return res;
    }

    /*
     * заправляет автомобиль
     * возвращает статус операции
     * */
    public String refuel(double refuelValue) {
        String res;
        double reqValue = tankCapacity - fuelValue;
        if (refuelValue > 0) {
            if (reqValue >= refuelValue) {
                fuelValue += refuelValue;
                res = "*автомобиль успешно заправлен*";
            } else {
                fuelValue = tankCapacity;
                res = "*автомобиль успешно заправлен*";
            }
        } else {
            res = "*неправильный объем заправки*";
        }
        return res;
    }

    /*
     *возвращает информацию об установленных колесах
     * */
    public String getWheelsInfo() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < this.wheels.length; i++) {
            if (this.wheels[i] == null) {
                res.append("на " + i + "-м месте колесо не установлено.\n");
            } else {
                res.append("на " + i + "-м месте установлено колесо " + this.wheels[i] + "\n");
            }
        }
        res.append("\b");
        return res.toString();
    }

    /*
     *возвращает информацию о состоянии двигателя
     * */
    public String getEngineInfo() {
        StringBuilder res = new StringBuilder();
        res.append("двигатель N " + this.engine.getId() + "\nсостояние - ");
        if (this.engine.isStarted()) {
            res.append("заведен.");
        } else {
            res.append("заглушен.");
        }
        return res.toString();
    }

    /*
     * возвращает текущее состояние автомобиля
     * */
    public String getInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Автомобиль N " + id + "\nдвигатель ");
        String engineStatus = engine.isStarted() ? "заведен" : "заглушен";
        res.append(engineStatus + "\nавтомобиль ");
        String autoStatus = isMoving() ? "движется" : "остановлен";
        String fuelVal = String.format("%.0f %%", fuelValue / tankCapacity * 100);
        res.append(autoStatus + "\nуровень топлива " + fuelVal);
        return res.toString();
    }

    /*
     * возвращает марку автомобиля
     * */
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Автомобиль ID " + id + ", Марка " + brand;
    }
}
