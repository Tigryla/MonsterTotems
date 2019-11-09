/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.client.particles;

import io.github.mspacedev.handlers.RegistryEventHandler;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.concurrent.ThreadLocalRandom;

public class ParticleMagic extends Particle
{
	private final double xCoord;
	private final double yCoord;
	private final double zCoord;
	private final BlockPos pos;
	private float orbitDistance;
	private float xyAngle;
	private float zAngle;
	private float fadeSpeed;
	private float fadeStartAge;
	private double speedRand;
	private double alphaRand;
	private double spawnRand1;
	private double spawnRand2;

	private boolean hasReachedAlphaMax;

	public ParticleMagic(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, float colorRed, float colorGreen, float colorBlue)
	{
		super(worldIn, xCoordIn, yCoordIn, zCoordIn);
		this.particleRed = colorRed;
		this.particleGreen = colorGreen;
		this.particleBlue = colorBlue;
		this.particleGravity = 0.0f;
		this.particleMaxAge = 100;
		this.particleAlpha = 0.0f;
		this.fadeSpeed = 0.025f;
		this.fadeStartAge = this.particleMaxAge - (1.0f / fadeSpeed);
		this.orbitDistance = (float) ThreadLocalRandom.current().nextDouble(0.8D, 1.0D);

		this.speedRand = (float) ThreadLocalRandom.current().nextDouble(0.2D, 0.4D);
		this.alphaRand = (float) ThreadLocalRandom.current().nextDouble(0.5D, 0.8D);
		this.spawnRand1 = this.spawnRand2 = (float) ThreadLocalRandom.current().nextDouble(0D, 2 * Math.PI);

		this.posX = xCoordIn + (orbitDistance * Math.cos(spawnRand1) * Math.sin(spawnRand2));
		this.posY = yCoordIn + (orbitDistance * Math.sin(spawnRand1) * Math.sin(spawnRand2));
		this.posZ = zCoordIn + (orbitDistance * Math.cos(spawnRand2));

		this.xCoord = xCoordIn;
		this.yCoord = yCoordIn;
		this.zCoord = zCoordIn;
		this.pos = new BlockPos(xCoordIn, yCoordIn, zCoordIn);

		this.setParticleTexture(RegistryEventHandler.textureAtlasSprite);
	}

	@Override
	public boolean shouldDisableDepth()
	{
		return true;
	}

	@Override
	public void move(double x, double y, double z)
	{
		xyAngle += 0.125f * speedRand;
		zAngle += 0.25f * speedRand;

		this.posX = xCoord + (orbitDistance * Math.cos(spawnRand1 + xyAngle) * Math.sin(spawnRand2 + zAngle));
		this.posY = yCoord + (orbitDistance * Math.sin(spawnRand1 + xyAngle) * Math.sin(spawnRand2 + zAngle));
		this.posZ = zCoord + (orbitDistance * Math.cos(spawnRand2 + zAngle));
	}

	@Override
	public void renderParticle(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ)
	{
		float f = (float) this.particleTextureIndexX / 16.0F;
		float f1 = f + 0.0624375F;
		float f2 = (float) this.particleTextureIndexY / 16.0F;
		float f3 = f2 + 0.0624375F;
		float f4 = 0.1F * this.particleScale;

		if (this.particleTexture != null)
		{
			int particleIndexU = 1;
			int particleIndexV = 1;

			float mapSizeU = this.particleTexture.getMaxU() - this.particleTexture.getMinU();
			float mapSizeV = this.particleTexture.getMaxV() - this.particleTexture.getMinV();
			float particleSizeU = mapSizeU / 4.0f * particleIndexU;
			float particleSizeV = mapSizeV / 4.0f * particleIndexV;

			f = this.particleTexture.getMinU() + mapSizeU / 16.0f * (particleIndexU - 1);
			f1 = this.particleTexture.getMinU() + particleSizeU;
			f2 = this.particleTexture.getMinV() + mapSizeV / 16.0f * (particleIndexV - 1);
			f3 = this.particleTexture.getMinV() + particleSizeV;
		}

		float f5 = (float) (this.prevPosX + (this.posX - this.prevPosX) * (double) partialTicks - interpPosX);
		float f6 = (float) (this.prevPosY + (this.posY - this.prevPosY) * (double) partialTicks - interpPosY);
		float f7 = (float) (this.prevPosZ + (this.posZ - this.prevPosZ) * (double) partialTicks - interpPosZ);
		int i = this.getBrightnessForRender(partialTicks);
		int j = i >> 16 & 65535;
		int k = i & 65535;
		Vec3d[] avec3d = new Vec3d[]{new Vec3d((double) (-rotationX * f4 - rotationXY * f4), (double) (-rotationZ * f4), (double) (-rotationYZ * f4 - rotationXZ * f4)), new Vec3d((double) (-rotationX * f4 + rotationXY * f4), (double) (rotationZ * f4), (double) (-rotationYZ * f4 + rotationXZ * f4)), new Vec3d((double) (rotationX * f4 + rotationXY * f4), (double) (rotationZ * f4), (double) (rotationYZ * f4 + rotationXZ * f4)), new Vec3d((double) (rotationX * f4 - rotationXY * f4), (double) (-rotationZ * f4), (double) (rotationYZ * f4 - rotationXZ * f4))};

		if (this.particleAngle != 0.0F)
		{
			float f8 = this.particleAngle + (this.particleAngle - this.prevParticleAngle) * partialTicks;
			float f9 = MathHelper.cos(f8 * 0.5F);
			float f10 = MathHelper.sin(f8 * 0.5F) * (float) cameraViewDir.x;
			float f11 = MathHelper.sin(f8 * 0.5F) * (float) cameraViewDir.y;
			float f12 = MathHelper.sin(f8 * 0.5F) * (float) cameraViewDir.z;
			Vec3d vec3d = new Vec3d((double) f10, (double) f11, (double) f12);

			for (int l = 0; l < 4; ++l)
			{
				avec3d[l] = vec3d.scale(2.0D * avec3d[l].dotProduct(vec3d)).add(avec3d[l].scale((double) (f9 * f9) - vec3d.dotProduct(vec3d))).add(vec3d.crossProduct(avec3d[l]).scale((double) (2.0F * f9)));
			}
		}

		buffer.pos((double) f5 + avec3d[0].x, (double) f6 + avec3d[0].y, (double) f7 + avec3d[0].z).tex((double) f1, (double) f3).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j, k).endVertex();
		buffer.pos((double) f5 + avec3d[1].x, (double) f6 + avec3d[1].y, (double) f7 + avec3d[1].z).tex((double) f1, (double) f2).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j, k).endVertex();
		buffer.pos((double) f5 + avec3d[2].x, (double) f6 + avec3d[2].y, (double) f7 + avec3d[2].z).tex((double) f, (double) f2).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j, k).endVertex();
		buffer.pos((double) f5 + avec3d[3].x, (double) f6 + avec3d[3].y, (double) f7 + avec3d[3].z).tex((double) f, (double) f3).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j, k).endVertex();
	}

	@Override
	public int getFXLayer()
	{
		return 1;
	}

	@Override
	public void onUpdate()
	{
		// Fades in and out particle
		if (particleAlpha < alphaRand && !hasReachedAlphaMax)
		{
			particleAlpha += fadeSpeed;
			if (particleAlpha >= alphaRand)
			{ // When max alpha is reached, stop adding alpha
				hasReachedAlphaMax = true;
			}
		} else if ((particleAge > fadeStartAge && particleAlpha >= 0))
		{
			particleAlpha -= fadeSpeed;
		} else if (world.getTileEntity(pos) == null && particleAlpha >= fadeSpeed)
		{
			particleAlpha -= fadeSpeed;
		}

		super.onUpdate();
	}
}
