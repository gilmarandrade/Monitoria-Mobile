package br.ufrn.imd.monitoria_mobile.helper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

/**
 * Created by gilmar.andrade on 11/10/2016.
 */

public class RoundedImageView {

    /**
     * Cria uma imagem com borda arrendodada a partir de um drawable
     *
     * Drawable roundedImage = RoundedImageView.getRoundedImageView(R.drawable.nomeDrawable, 80, 80, 200.0f, getResources());
     * imageView.setImageDrawable(roundedImage);
     *
     * @param drawable id da imagem que será desenhada
     * @param width
     * @param height
     * @param cornerRadius border radius da imagem
     * @param mResources
     * @return objeto drawable que pode ser inserido através de: imageView.setImageDrawable()
     */
    public static Drawable getRoundedImageView(int drawable, int width, int height, float cornerRadius, Resources mResources) {

        // Get the bitmap from drawable resources
        Bitmap  mBitmap = BitmapFactory.decodeResource(mResources, drawable);

        //redimensiona
        mBitmap = Bitmap.createScaledBitmap(mBitmap, width, height, true);


        /*
            RoundedBitmapDrawable
                A Drawable that wraps a bitmap and can be drawn with rounded corners. You
                can create a RoundedBitmapDrawable from a file path, an input stream, or
                from a Bitmap object.
        */
        /*
            RoundedBitmapDrawableFactory
                Constructs RoundedBitmapDrawable objects, either from Bitmaps directly, or
                from streams and files.

            public static RoundedBitmapDrawable create (Resources res, Bitmap bitmap)
                Returns a new drawable by creating it from a bitmap, setting initial target
                density based on the display metrics of the resources.
        */
        // Initialize a new RoundedBitmapDrawable object to make ImageView rounded corners
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(
                mResources,
                mBitmap
        );

        // Set the RoundedBitmapDrawable corners radius
        roundedBitmapDrawable.setCornerRadius(cornerRadius);

        /*
            setAntiAlias(boolean aa)
                Enables or disables anti-aliasing for this drawable.
        */
        roundedBitmapDrawable.setAntiAlias(true);

        return roundedBitmapDrawable;
        //imageView.setImageBitmap(resizedbitmap);
        //imageView.setImageDrawable(roundedBitmapDrawable);
    }

    /**
     * Cria uma imagem com borda arrendodada a partir de um drawable
     *
     * Drawable roundedImage = RoundedImageView.getRoundedImageView(R.drawable.nomeDrawable, 80, 80, 200.0f, getResources());
     * imageView.setImageDrawable(roundedImage);
     *
     * @param drawable id da imagem que será desenhada
     * @param cornerRadius border radius da imagem
     * @param mResources
     * @return objeto drawable que pode ser inserido através de: imageView.setImageDrawable()
     */
    public static Drawable getRoundedImageView(int drawable, float cornerRadius, Resources mResources) {

        // Get the bitmap from drawable resources
        Bitmap  mBitmap = BitmapFactory.decodeResource(mResources, drawable);


        /*
            RoundedBitmapDrawable
                A Drawable that wraps a bitmap and can be drawn with rounded corners. You
                can create a RoundedBitmapDrawable from a file path, an input stream, or
                from a Bitmap object.
        */
        /*
            RoundedBitmapDrawableFactory
                Constructs RoundedBitmapDrawable objects, either from Bitmaps directly, or
                from streams and files.

            public static RoundedBitmapDrawable create (Resources res, Bitmap bitmap)
                Returns a new drawable by creating it from a bitmap, setting initial target
                density based on the display metrics of the resources.
        */
        // Initialize a new RoundedBitmapDrawable object to make ImageView rounded corners
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(
                mResources,
                mBitmap
        );

        // Set the RoundedBitmapDrawable corners radius
        roundedBitmapDrawable.setCornerRadius(cornerRadius);

        /*
            setAntiAlias(boolean aa)
                Enables or disables anti-aliasing for this drawable.
        */
        roundedBitmapDrawable.setAntiAlias(true);

        return roundedBitmapDrawable;
        //imageView.setImageBitmap(resizedbitmap);
        //imageView.setImageDrawable(roundedBitmapDrawable);
    }
}
