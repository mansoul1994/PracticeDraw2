package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice12PathEffectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    public Practice12PathEffectView(Context context) {
        super(context);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        PathEffect effect;
        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        effect = new CornerPathEffect(20);
        paint.setPathEffect(effect);
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(500, 0);
        // 第二处：DiscretePathEffect
        effect = new DiscretePathEffect(19, 30);
        paint.setPathEffect(effect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        // 第三处：DashPathEffect
        effect = new DashPathEffect(new float[]{10, 20}, 100);
        paint.setPathEffect(effect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        // 第四处：PathDashPathEffect
        Path dashPath = new Path();
        dashPath.rLineTo(40, 0);
        dashPath.rLineTo(-20, 20);
        dashPath.rLineTo(-20, -20);
        effect = new PathDashPathEffect(dashPath, 50, 0,
                PathDashPathEffect.Style.MORPH);
        paint.setPathEffect(effect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        // 第五处：SumPathEffect
        DiscretePathEffect effect1 = new DiscretePathEffect(19, 30);
        DashPathEffect effect2 = new DashPathEffect(new float[]{10, 20}, 0);
        effect = new SumPathEffect(effect1, effect2);
        paint.setPathEffect(effect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        // 第六处：ComposePathEffect
        effect = new SumPathEffect(effect1, effect2);
        paint.setPathEffect(effect);
        canvas.drawPath(path, paint);
        canvas.restore();
    }
}
