package com.example.colculationart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

public class HelloController {

    @FXML
    private Label welcomeText;
    @FXML
    private Label WhachLable;
    @FXML
    private Label GobletLable;
    @FXML
    private Label HatLabel;

    @FXML
    private ChoiceBox<String> ChoiceCharacterStatusBox;

    @FXML
    ImageView CharcterView;
    @FXML
    ImageView ArtUiLabel;
    @FXML
    Button myButton;
    @FXML
    private Label Testlable;

    Image Ui_Alhaitham = new Image("file:///C:/Users/Алексей/IdeaProjects/Colculationart/src/main/resources/com/example/colculationart/image/1_Alhaitham.png");

    private String[] Character = {"Аль-Хайтам", "Альбедо", "Аяка", "Аято", "Венти", "Гань Юй", "Джин", "Дилюк", "Дэхья", "Е Лань", "Ёимия", "Итто", "Кадзуха", "Кли", "Кокоми", "Кэ Цин", "ГГ (Анемо)", "ГГ (Гео)", "ГГ (Электро)", "ГГ (Дендро)", "Мона", "Нахида", "Нилу", "Райдэн", "Сайно", "Странник", "Сяо", "Тарталья", "Тигнари", "Ху Тао", "Ци Ци", "Чжун Ли", "Шань Хэ", "Элой", "Эола", "Яэ Мико", "Барбара", "Беннет", "Бэй Доу", "Горо", "Диона", "Дори", "Кандакия", "Коллеи", "Кэйа", "Лайла", "Лиза", "Мика", "Нин Гуан", "Ноэлль", "Розария", "Рейзор", "Сара", "Сахароза", "Саю", "Син Цю", "Синобу", "Синь Янь", "Сян Лин", "Тома", "Фарузан", "Фишель", "Хейдзо", "Чун Юнь", "Эмбер", "Юнь Цзинь", "Янь Фей", "Яо Яо"};
    @FXML
    private void initialize(){
        ChoiceCharacterStatusBox.getItems().addAll(Character);
        ChoiceCharacterStatusBox.setOnAction(this::getCharacter);
    }

    public void displayImage(){
       CharcterView.setImage(Ui_Alhaitham);
    }
    public void getCharacter(ActionEvent event) {
        Character Alhaitham = new Character(1, 214, new int[]{7,15,20,7,8,9,10,4});
        Character Albedo = new Character(2, 219, new int[]{6,14,20,6,9,10});
        Character Ayaka = new Character(3, 204, new int[]{4,16,10,10,8,4,9});
        Character Ayato = new Character(4, 210, new int[]{4,13,20,8,20,4,2});
        Character Venti = new Character(5, 231, new int[]{7,7,7,7,8,4,9,10});
        Character Ganyu = new Character(6, 235, new int[]{4,16,20,10,9,7,4});
        Character Jean = new Character(7, 447, new int[]{4,12,20,4,8,10});
        Character Diluc = new Character(8, 207, new int[]{21,17,20,10,9,4,7});
        Character Dehya = new Character(9, 207, new int[]{21,17,20,8,9,10,7,4,2});
        Character Yelan = new Character(10, 212, new int[]{2,13,20,8,2,20});
        Character Yoimiya = new Character(11, 235, new int[]{4,17,20,10,9,4,7,8});
        Character Itto = new Character(12, 219, new int[]{6,14,20,6,10,9,8});
        Character Kazuha = new Character(13, 231, new int[]{21,31,22,7,8,10,9,4});
        Character Klee = new Character(14, 207, new int[]{4,17,20,10,9,4,7});
        Character Kokomi = new Character(15, 228, new int[]{2,13,23,2,8,7});
        Character Keqing = new Character(16, 217, new int[]{21,18,20,9,10,4,7});
        Character GGAnemo = new Character(17, 231, new int[]{8,12,20,8,9});
        Character GGGeo = new Character(18, 212, new int[]{24,14,20,8,9,10,4});
        Character GGElectro = new Character(19, 227, new int[]{24,18,20,4,10,9,8});
        Character GGDendro = new Character(20, 208, new int[]{25,15,20,8,7,9,10});
        Character Mona = new Character(21, 212, new int[]{4,13,20,8,10,9,4});
        Character Nahida = new Character(22, 208, new int[]{7,32,22,7,9,10,8});
        Character Nilou = new Character(23, 881, new int[]{26,2,2,2,8,1,7});
        Character RaidenShogun = new Character(24, 212, new int[]{24,33,20,10,9,8,4});
        Character Cyno = new Character(25, 214, new int[]{7,18,20,20,8,7,4});
        Character Wanderer = new Character(26, 211, new int[]{4,12,20,9,10,8,4});
        Character Xiao = new Character(27, 233, new int[]{4,12,20,10,9,4,8});
        Character Tartaglia = new Character(28, 218, new int[]{4,13,20,4,9,10,7});
        Character Tighnari = new Character(29, 208, new int[]{21,15,20,9,10,4,7});
        Character HuTao = new Character(30, 207, new int[]{2,17,20,9,10,2,7});
        Character Qiqi = new Character(31, 222, new int[]{24,4,27,4,3,8});
        Character Zhongli = new Character(32, 429, new int[]{4,14,20,4,2,9,10,8});
        Character Shenhe = new Character(33, 451, new int[]{24,4,4,4,8});
        Character Aloy = new Character(34, 425, new int[]{4,16,20,8,10,9,4});
        Character Eula = new Character(35, 229, new int[]{4,11,20,8,10,9,4});
        Character YaeMiko = new Character(36, 433, new int[]{24,18,20,8,9,10,4,7});
        Character Barbara = new Character(37, 214, new int[]{7,7,7,7,2});
        Character Bennett = new Character(38, 227, new int[]{24,17,20,8,9,10,4});
        Character Beidou = new Character(39, 443, new int[]{4,18,20,4,9,10,8});
        Character Gorou = new Character(40, 219, new int[]{28,6,6,6,8,9});
        Character Diona = new Character(41, 227, new int[]{26,2,23,8,2,1});
        Character Dori = new Character(42, 227, new int[]{26,2,23,8,2,4,9});
        Character Candace = new Character(43, 218, new int[]{4,13,20,9,10,2,4,7});
        Character Collei = new Character(44, 212, new int[]{41,15,20,8,9,10,4,7});
        Character Kaeya = new Character(45, 204, new int[]{4,16,10,10,4,9});
        Character Layla = new Character(46, 222, new int[]{2,34,42,2,9,10,8});
        Character Lisa = new Character(47, 212, new int[]{24,18,20,8,9,10,4});
        Character Mika = new Character(48, 227, new int[]{26,2,2,8,2});
        Character Ningguang = new Character(49, 418, new int[]{4,14,20,9,10,4});
        Character Noelle = new Character(50, 225, new int[]{6,6,35,8,5});
        Character Rosaria = new Character(51, 229, new int[]{4,11,20,10,9,4});
        Character Razor = new Character(52, 229, new int[]{4,11,20,4,9,10,8});
        Character Sara = new Character(53, 227, new int[]{24,18,20,4,10,9,8});
        Character Sucrose = new Character(54, 231, new int[]{21,31,36,8,7,9,10});
        Character Sayu = new Character(55, 231, new int[]{4,12,20,8,10,9});
        Character Xingqiu = new Character(56, 212, new int[]{24,13,20,8,10,9,4,7});
        Character KukiShinobu = new Character(57, 214, new int[]{7,7,7,7,2,8});
        Character Xinyan = new Character(58, 434, new int[]{24,29,20,4,10});
        Character Xiangling = new Character(59, 212, new int[]{21,17,20,8,10,9,4,7});
        Character Thoma = new Character(60, 213, new int[]{25,7,7,7,8,4});
        Character Faruzan = new Character(61, 231, new int[]{24,12,20,8,9,10});
        Character Fischl = new Character(62, 443, new int[]{4,33,20,9,10,4});
        Character Heizou = new Character(63, 231, new int[]{7,7,7,7,4,9,10});
        Character Chongyun = new Character(64, 420, new int[]{4,16,20,9,10,4,7});
        Character Amber = new Character(65, 212, new int[]{4,17,20,8,4,9,10});
        Character YunJin = new Character(66, 234, new int[]{43,11,20,8,9,10,4});
        Character Yanfei = new Character(67, 207, new int[]{4,17,20,4,7,10,9});
        Character Yaoyao = new Character(68, 208, new int[]{8,2,44,8,20,7,2});
        String myCharacter = ChoiceCharacterStatusBox.getValue();
        Testlable.setText(myCharacter);
        switch (myCharacter){
            case ("Аль-Хайтам"):
                DisplayUiLabel(Alhaitham);
                break;
            case ("Альбедо"):
                DisplayUiLabel(Albedo);
                break;
            case ("Аяка"):
                DisplayUiLabel(Ayaka);
                break;
            case ("Аято"):
                DisplayUiLabel(Ayato);
                break;
            case ("Венти"):
                DisplayUiLabel(Venti);
                break;
            case ("Гань Юй"):
                DisplayUiLabel(Ganyu);
                break;
            case ("Джин"):
                DisplayUiLabel(Jean);
                break;
            case ("Дилюк"):
                DisplayUiLabel(Diluc);
                break;
            case ("Дэхья"):
                DisplayUiLabel(Dehya);
                break;
            case ("Е Лань"):
                DisplayUiLabel(Yelan);
                break;
            case ("Ёимия"):
                DisplayUiLabel(Yoimiya);
                break;
            case ("Итто"):
                DisplayUiLabel(Itto);
                break;
            case ("Кадзуха"):
                DisplayUiLabel(Kazuha);
                break;
            case ("Кли"):
                DisplayUiLabel(Klee);
                break;
            case ("Кокоми"):
                DisplayUiLabel(Kokomi);
                break;
            case ("Кэ Цин"):
                DisplayUiLabel(Keqing);
                break;
            case ("ГГ (Анемо)"):
                DisplayUiLabel(GGAnemo);
                break;
            case ("ГГ (Гео)"):
                DisplayUiLabel(GGGeo);
                break;
            case ("ГГ (Электро)"):
                DisplayUiLabel(GGElectro);
                break;
            case ("ГГ (Дендро)"):
                DisplayUiLabel(GGDendro);
                break;
            case ("Мона"):
                DisplayUiLabel(Mona);
                break;
            case ("Нахида"):
                DisplayUiLabel(Nahida);
                break;
            case ("Нилу"):
                DisplayUiLabel(Nilou);
                break;
            case ("Райдэн"):
                DisplayUiLabel(RaidenShogun);
                break;
            case ("Сайно"):
                DisplayUiLabel(Cyno);
                break;
            case ("Странник"):
                DisplayUiLabel(Wanderer);
                break;
            case ("Сяо"):
                DisplayUiLabel(Xiao);
                break;
            case ("Тарталья"):
                DisplayUiLabel(Tartaglia);
                break;
            case ("Тигнари"):
                DisplayUiLabel(Tighnari);
                break;
            case ("Ху Тао"):
                DisplayUiLabel(HuTao);
                break;
            case ("Ци Ци"):
                DisplayUiLabel(Qiqi);
                break;
            case ("Чжун Ли"):
                DisplayUiLabel(Zhongli);
                break;
            case ("Шань Хэ"):
                DisplayUiLabel(Shenhe);
                break;
            case ("Элой"):
                DisplayUiLabel(Aloy);
                break;
            case ("Эола"):
                DisplayUiLabel(Eula);
                break;
            case ("Яэ Мико"):
                DisplayUiLabel(YaeMiko);
                break;
            case ("Барбара"):
                DisplayUiLabel(Barbara);
                break;
            case ("Беннет"):
                DisplayUiLabel(Bennett);
                break;
            case ("Бэй Доу"):
                DisplayUiLabel(Beidou);
                break;
            case ("Горо"):
                DisplayUiLabel(Gorou);
                break;
            case ("Диона"):
                DisplayUiLabel(Diona);
                break;
            case ("Дори"):
                DisplayUiLabel(Dori);
                break;
            case ("Кандакия"):
                DisplayUiLabel(Candace);
                break;
            case ("Коллеи"):
                DisplayUiLabel(Collei);
                break;
            case ("Кэйа"):
                DisplayUiLabel(Kaeya);
                break;
            case ("Лайла"):
                DisplayUiLabel(Layla);
                break;
            case ("Лиза"):
                DisplayUiLabel(Lisa);
                break;
            case ("Мика"):
                DisplayUiLabel(Mika);
                break;
            case ("Нин Гуан"):
                DisplayUiLabel(Ningguang);
                break;
            case ("Ноэлль"):
                DisplayUiLabel(Noelle);
                break;
            case ("Розария"):
                DisplayUiLabel(Rosaria);
                break;
            case ("Рейзор"):
                DisplayUiLabel(Razor);
                break;
            case ("Сара"):
                DisplayUiLabel(Sara);
                break;
            case ("Сахароза"):
                DisplayUiLabel(Sucrose);
                break;
            case ("Саю"):
                DisplayUiLabel(Sayu);
                break;
            case ("Син Цю"):
                DisplayUiLabel(Xingqiu);
                break;
            case ("Синобу"):
                DisplayUiLabel(KukiShinobu);
                break;
            case ("Синь Янь"):
                DisplayUiLabel(Xinyan);
                break;
            case ("Сян Лин"):
                DisplayUiLabel(Xiangling);
                break;
            case ("Тома"):
                DisplayUiLabel(Thoma);
                break;
            case ("Фарузан"):
                DisplayUiLabel(Faruzan);
                break;
            case ("Фишель"):
                DisplayUiLabel(Fischl);
                break;
            case ("Хейдзо"):
                DisplayUiLabel(Heizou);
                break;
            case ("Чун Юнь"):
                DisplayUiLabel(Chongyun);
                break;
            case ("Эмбер"):
                DisplayUiLabel(Amber);
                break;
            case ("Юнь Цзинь"):
                DisplayUiLabel(YunJin);
                break;
            case ("Янь Фей"):
                DisplayUiLabel(Yanfei);
                break;
            case ("Яо Яо"):
                DisplayUiLabel(Yaoyao);
                break;
            default:
                break;
        }
    }


    public void DisplayUiLabel(Character chrctr){
        HashMap<Integer, String> UiBelongCharacterName = UiMap.GetUiMap();
        HashMap<Integer, String> UiBelongArtName = UiMap.GetArtNameMap();
        HashMap<Integer, String> ArtStatName = UiMap.GetArtStatMap();
        CharcterView.setImage(GetUiImaga.GetImageUiCharacter(UiBelongCharacterName.get(chrctr.i_id_chr_name)));
        ArtUiLabel.setImage(GetUiImaga.GetImageUiArt(UiBelongArtName.get(chrctr.s_main_set)));
        //цSystem.out.println(UiBelongArtName.get(chrctr.s_main_set));
        WhachLable.setText(ArtStatName.get(chrctr.arr_i_bst_chr_art_stats[1]));
        GobletLable.setText(ArtStatName.get(chrctr.arr_i_bst_chr_art_stats[2]));
        HatLabel.setText(ArtStatName.get(chrctr.arr_i_bst_chr_art_stats[3]));
    }

}