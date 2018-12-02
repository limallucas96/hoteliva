package com.example.lucas.deliva.mechanism.connection.utils;

import com.example.lucas.deliva.data.model.OrderDetailImage;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailMock {

    private static List<OrderDetailImage> orderDetailImage;

    public static List<OrderDetailImage> createOrderDetail() {
        orderDetailImage = new ArrayList<>();

        List<String> pudimImageList = new ArrayList<>();
        pudimImageList.add("https://site-amb-s3.clubedaana.com.br/prod/imagens/receita/18055/pudim-de-leite-sem-furinhos-21520.jpg");
        pudimImageList.add("http://s.glbimg.com/po/rc/media/2015/09/22/10_19_02_409_Pudim.png");
        pudimImageList.add("https://www.receitas-sem-fronteiras.com/media/pudim-2_crop.jpg/rh/pudim-de-leite-moca.jpg");
        pudimImageList.add("http://s.glbimg.com/po/rc/media/2015/09/16/15_17_23_824_00001_61.png");
        pudimImageList.add("https://img.itdg.com.br/tdg/images/recipes/000/024/104/263980/263980_original.jpg");
        orderDetailImage.add(new OrderDetailImage("5", pudimImageList, "5.0", "1-2 Pessoas", "45 min"));

        List<String> passionFruitMousseList = new ArrayList<>();
        passionFruitMousseList.add("https://guiadacozinha.com.br/wp-content/uploads/2016/04/Mousse-maracuja.jpg");
        passionFruitMousseList.add("https://site-amb-s3.clubedaana.com.br/prod/imagens/receita/16655/torta-mousse-de-maracuja-chocolate-e-suspiro-17486.jpg");
        passionFruitMousseList.add("https://guiadacozinha.com.br/wp-content/uploads/2004/01/torta-de-maracuja-sem-acucar-e-sem-lactose-51972-650x421.jpg");
        passionFruitMousseList.add("http://s.glbimg.com/po/rc/media/2015/03/30/14_49_45_742_mousse.jpg");
        passionFruitMousseList.add("http://s.glbimg.com/po/rc/media/2014/01/21/11_29_01_852_receita_torta_musse_de_maracuja.jpg");
        orderDetailImage.add(new OrderDetailImage("6", passionFruitMousseList, "4.8", "1-3 Pessoas", "1h"));

        List<String> chocolateMousseList = new ArrayList<>();
        chocolateMousseList.add("https://img.cybercook.uol.com.br/receitas/761/mousse-de-chocolate-em-po-delicia-2.jpeg");
        chocolateMousseList.add("https://www.recipetineats.com/wp-content/uploads/2018/09/Chocolate-Mousse_9-819x1024.jpg");
        chocolateMousseList.add("https://i1.wp.com/acasaencantada.com.br/wp-content/uploads/2015/08/DSC_1522.jpg");
        chocolateMousseList.add("https://static.cuisineaz.com/680x357/i103686-mousse-au-chocolat-light.jpg");
        chocolateMousseList.add("https://melepimenta.com/wp-content/uploads/2018/09/Mousse-de-chocolate-amargo-Paola-carosella-Baixa-3.jpg");
        orderDetailImage.add(new OrderDetailImage("7", chocolateMousseList, "4.7", "1-3 Pessoas", "1h"));

        List<String> meatList = new ArrayList<>();
        meatList.add("https://abrilmdemulher.files.wordpress.com/2016/10/receita-picanha-recheada.jpg");
        meatList.add("https://abrilmdemulher.files.wordpress.com/2016/10/receita-alcatra-panela-recheada.jpg");
        meatList.add("https://t2.rg.ltmcdn.com/pt/images/6/4/7/img_cupim_assado_no_forno_5746_600.jpg");
        meatList.add("http://s.glbimg.com/po/rc/media/2014/06/05/11_48_33_195_receita_carne_assada.jpg");
        meatList.add("https://abrilmdemulher.files.wordpress.com/2016/10/receita-coxao-duro-recheado.jpg");
        orderDetailImage.add(new OrderDetailImage("8", meatList, "4.6", "5 Pessoas", "40min"));

        List<String> pastaList = new ArrayList<>();
        pastaList.add("https://abrilmdemulher.files.wordpress.com/2017/07/macarrc3a3o-pad-thai-1.jpg");
        pastaList.add("http://www.eujacomi.com.br/wp-content/uploads/2015/03/pad-thai-lombo.jpg");
        pastaList.add("https://img.itdg.com.br/tdg/images/recipes/000/069/646/58417/58417_original.jpg");
        pastaList.add("http://s.glbimg.com/po/rc/media/2012/06/13/15/41/41/968/Yakissoba_de_Legumes.jpg");
        pastaList.add("http://www.foodmagazine.com.br/imagens/receitas/receita_catupiry_macarrao_camarao.jpg");
        orderDetailImage.add(new OrderDetailImage("9", pastaList, "4.9", "1-2 Pessoas", "1h30min"));

        List<String> sandwishList = new ArrayList<>();
        sandwishList.add("https://2.kekantoimg.com/5Skp0EyW5OClYItG3NwpwUozpco=/fit-in/600x600/s3.amazonaws.com/kekanto_pics/pics/442/148442.jpg");
        sandwishList.add("https://3.kekantoimg.com/AoF9J5PBIki0i5jmUs-8xJ_HmhA=/520x205/s3.amazonaws.com/kekanto_pics/pics/563/807563.jpg");
        sandwishList.add("https://www.lista19.com.br/admin/fotos/estabelecimentos/777/est_777_foto_1943.jpg");
        sandwishList.add("https://images2.nogueirense.com.br/wp-content/uploads/9999/11/whatsapp-image-2018-11-01-at-14-47-20-1-1541698312-768x668.jpeg");
        sandwishList.add("https://s3-media4.fl.yelpcdn.com/bphoto/MDJhGDkt7XJtbuEd-oaV2Q/o.jpg");
        orderDetailImage.add(new OrderDetailImage("10", sandwishList, "4.2", "3 Pessoas", "1h"));

        List<String> merlusaFishList = new ArrayList<>();
        merlusaFishList.add("https://i0.wp.com/comsaborperfeito.com/wp-content/uploads/2014/08/1326231271.jpg?resize=622%2C460");
        merlusaFishList.add("https://www.comidaereceitas.com.br/img/sizes/600x400/2013/10/isca_peixe_crocante.jpg");
        merlusaFishList.add("https://www.mundoboaforma.com.br/wp-content/uploads/2017/08/file-de-peixe-empanado-620x330.jpg");
        merlusaFishList.add("http://www.guiarestauranteseleto.com.br/img/upload/receitas/0/grandes/0-camarao-35.jpg");
        merlusaFishList.add("http://imirante.com/imagens/2015/10/07/1444229075-660963390.jpg");
        orderDetailImage.add(new OrderDetailImage("11", merlusaFishList, "5.0", "4-5 Pessoas", "1h"));

        List<String> lasagnaList = new ArrayList<>();
        lasagnaList.add("https://www.receitasnestle.com.br/images/default-source/recipes/lasanha_a_bolonhesa.jpg");
        lasagnaList.add("https://img.cybercook.uol.com.br/imagens/receitas/760/lasanha-de-camarao-com-abobrinha.jpg");
        lasagnaList.add("https://tarasmulticulturaltable.com/wp-content/uploads/2013/08/mushroom-kale-lasagna-rolls-2-of-3-1024x680.jpg");
        lasagnaList.add("https://mulherportuguesa.com/wp-content/uploads/2016/10/Receita-de-lasanha-%C3%A0-bolonhesa.jpg");
        lasagnaList.add("http://assets.kraftfoods.com/recipe_images/opendeploy/126659_640x428.jpg");
        orderDetailImage.add(new OrderDetailImage("12", lasagnaList, "4.9", "2-3 Pessoas", "1h"));

        List<String> soda2lList = new ArrayList<>();
        soda2lList.add("http://coopsp.vteximg.com.br/arquivos/ids/156412-804-804/7894900061512_Refrigerante-Sprite---2L.jpg");
        orderDetailImage.add(new OrderDetailImage("13", soda2lList, "4.0", "4 Pessoas", "0 min"));

        List<String> sodaCanList = new ArrayList<>();
        sodaCanList.add("https://www.zonasul.com.br/Content/images/imagem1000X1000/2018620_11524.jpg");
        orderDetailImage.add(new OrderDetailImage("14", sodaCanList, "4.0", "1 Pessoa", "0 min"));

        List<String> grapeSodaCanList = new ArrayList<>();
        grapeSodaCanList.add("https://www.zonasul.com.br/Content/images/imagem1000X1000/2018620_11705.jpg");
        orderDetailImage.add(new OrderDetailImage("15", grapeSodaCanList, "4.0", "1 Pessoa", "0 min"));

        return orderDetailImage;
    }


}
